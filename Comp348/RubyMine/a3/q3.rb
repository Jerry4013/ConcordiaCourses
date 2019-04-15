# maintain a Hash for the number of each car maker. for example {"Toyota" => 2, "Mercedes" => 1}
class CarMaker
  attr_accessor :carCounter
  @@carCounter = Hash.new
  def self.carCounter
    @@carCounter
  end
end

# maintain all the cars with all 12 features as instance variable.
class CarModel < CarMaker
  attr_accessor :car_maker
  include Comparable

  #This class_variable is used for converting a feature from its String expression to
  # instance variable name
  @@variableNameMap = {"#km"=>"@km", "Type"=>"@type", "Transmission"=>"@transmission",
                       "stock#"=>"@stock", "Drivetrain"=>"@drivetrain","Status"=>"@status",
                       "Fuel Economy"=>"@fuel", "car_maker"=>"@car_maker", "Year"=>"@year",
                       "Trim"=>"@trim", "set_of_features"=>"@set_of_features","Model"=>"@model"}
  #car is a hash that has all the information to create a CarModel Object
  def initialize(car)
    #first, update the number of objects
    value = @@carCounter[car["car_maker"]].to_i
    @@carCounter[car["car_maker"]] = value + 1
    #use @@variableNameMap to assign all the instance variable dynamically
    car.each { |feature, value| instance_variable_set(@@variableNameMap[feature], value)}
  end

  def to_s
    return "#{@car_maker},#{@model},#{@trim},#{@km},#{@year},#{@type},#{@drivetrain},"+
        "#{@transmission},#{@stock},#{@status},#{@fuel},#{@set_of_features}"
  end
end

$catalogue = Array.new # to save all the Car objects in an array, which is a global variable

# take a String fileName, extract all the information from the file, and store all the
# cars in an array, where each element is a car, represented by a Hash
def convertListings2Array(fileName)
  File.write(fileName, File.read(fileName).gsub(/\n+/,"\n"))
  vehicles = Array.new
  file = File.open(fileName)
  file.each do |line|
      car = convertLine2Car(line) unless line.chomp.empty?
      vehicles.push(car)
  end
  return vehicles
end

# take a fileName and save all the information in an array of CarModel Objects
def convertListings2Catalogue(fileName)
  vehicles = convertListings2Array(fileName)
  vehicles.each do |car|
    car = CarModel.new(car)
    $catalogue.push(car)
    puts "We are creating car:\n#{car}\n\n"
  end
end

# take a line of type String, use regex to convert it to a Hash, called car. Return this
# Hash as a single car
def convertLine2Car(line)
  car = Hash.new
  if(line.class != String)
    abort("ABORTED! ")
  end
  if(line == "")
    return
  end
  line.scan(/{.+}|[^,\s]+/) do |feature|
    case feature
    when /^[^\/]+km$/
      car["#km"] = feature
    when /^Sedan$|^coupe$|^hatchback$|^station$|^SUV$/i
      car["Type"] = feature
    when /^Auto$|^manual$|^steptronic$/i
      car["Transmission"] = feature
    when /^(?!\d+$)(?![a-zA-Z]+$)\w+(?<!km)$/i
      car["stock#"] = feature
    when /^FWD$|^RWD$|^AWD$/i
      car["Drivetrain"] = feature
    when /^Used$|^new$/
      car["Status"] = feature
    when /L\/\d+km$/
      car["Fuel Economy"] = feature
    when /^Honda$|^Toyota$|^Mercedes$|^BMW$|^Lexus$/i
      car["car_maker"] = feature
    when /^\d{4}$/
      car["Year"] = feature
    when /^[A-Z]{2}$/
      car["Trim"] = feature
    when /^{.*}$/
      car["set_of_features"] = feature
    else
      car["Model"] = feature
    end
  end
  return car
end

# Parameter: hash: searching criteria
# iterate all cars in the inventory, and compare with the hash criteria. If it matches,
# print this car
def searchInventory(hash)
  puts "Search inventory using hash #{hash}, the result is:\n"
  $catalogue.each do |car|
    match = true
    hash.each_pair do |key, value|
      variableName = CarModel.class_variable_get(:@@variableNameMap)[key]
      myValue = car.instance_variable_get(variableName)
      if (myValue != value)
        match = false
      end
    end
    if (match == true)
      puts car.to_s
    end
  end
end

# take a new feature line as type of String, add to the existing file. extract information and
# add to inventory,$catalogue
def add2Inventory(features, fileName)
  puts "\nAdd a new listing to the inventory:\n#{features}\n"
  file = File.open(fileName, "a")
  file.print("\n#{features}")
  car = convertLine2Car(features)
  $catalogue.push(CarModel.new(car))
end

def displayInventory
  puts "\nDisplaying all the cars in our inventory: \n"
  $catalogue.each do |car|
    puts car
  end
end

# Sort all the cars in $catalogue, then output to a new file, "output.txt"
def saveCatalogue2File
  $catalogue.sort { |a, b|  a.car_maker <=> b.car_maker }
  file = File.open("output.txt", 'w')
  $catalogue.each do |car|
    file.puts(car)
  end
  puts "\nWe have created a new file output.txt and printed all the cars in order.\n"
end

# save all the cars in $catalogue array
convertListings2Catalogue("listing.txt")

# pass a hash and search in $catalogue. If match, print it in console
searchInventory({"car_maker" => "Toyota", "Year"=>"2010"})

# a new line of features
features = "SUV,900km,auto,RWD, Toyota,CLK,LX ,1234A4A,2010,{AC, Heated Seats,"+
            "Heated Mirrors, Keyless Entry, Power seats},6L/100km,Used"
# add this feature in the inventory
add2Inventory(features, "listing.txt")

# display all the cars in inventory.
displayInventory

# Sort and output to "output.txt"
saveCatalogue2File

# check how many cars of each Car maker in the inventory
puts "\nCheck how many cars we have:\n #{CarModel.carCounter}"

