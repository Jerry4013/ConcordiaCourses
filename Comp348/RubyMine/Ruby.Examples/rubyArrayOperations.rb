#conline compiler://https://www.tutorialspoint.com/execute_ruby_online.php

# array operations:

a=["hello", 5,4]
puts a
myarray = [ 1, 2, 3, 4, 5, 6 ]
puts myarray[1...3]
print("\n")
puts myarray[1..3]
print("\n")
puts myarray[1,3]
print("\n")
puts a[-2]
print("\n")
b=a.dup
x=5
puts "value of b #{b}"
puts "value of x is #{x}"
puts b.class
puts "b length is #{b.length}"
b.delete(5)
puts b
b[2]="bye"
puts b
b.delete_at(0)
puts "after delet #{b}"
print("\n")

#iterate over array, delete from array
i=0
while(i<3)
puts "value of a #{i} is #{a[i]}"
i=i+1
end
print("\n")


biblio = { "nabokov89a" => "Pnin",
"bulgakov96" => "The master and margarita",
"nabokov89b" => 5,
"nabokov90" => "The defense",
"kafka95" => "The trial" }
puts biblio["nabokov89b"]
test={5=> "a", 4=> 6}
print("\n")
puts test[4]
biblio["bahar"]=10
print("\n")
puts biblio
biblio.delete_if{|key, value| key == "kafka95"}
print("\n")
puts biblio
print("\n")
biblio.each do |key, value|
puts "#{key} : #{value}"
end

#create an associative array
myarray=Hash.new
myarray["first"] = "Spring"
myarray["second"] = "Summer"
myarray["third"] = "Fall"
myarray["fourth"] = "Winter"
print ("\n")
puts(myarray)