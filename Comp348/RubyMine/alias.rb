class Alias
  person1 = "Tony"
  person2 = person1


  person3 = person1.dup
  person1[0] = "R"
  puts person1
  puts person2
  puts person3
end