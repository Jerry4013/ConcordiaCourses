def countCharacters(arr)
  if (arr.class != Array)
    return "The argument is not an array."
  end
  arr2 = arr.sort
  arr2.each {|ele| puts "#{ele}, ch_count= #{ele.length}"}
end

arr = ["Adam", "Eve", "Mark", "Franklin", "John"]
countCharacters(arr)
