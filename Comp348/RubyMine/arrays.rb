class Arrays
  myarray = [1, "a", "b", 4, 5, 6]
  puts myarray.join(" ")
  puts myarray[-2]
  puts myarray[1...3].join(" ")
  puts myarray[1..3].join(" ")
  puts myarray[1,3].join(" ")

  b = Array.new
  puts b.class
  b[0] = "a"
  b[1] = "new"
  b[2] = "array"
  puts b.join(" ")
end
