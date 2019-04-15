

class Chain
  a = b = 1 + 2 + 3
  puts a
  puts b
  puts

  a = (b = 1 + 2) + 3
  puts a
  puts b
  puts

  a = 5
  b = 2
  a, b = b, a
  puts a
  puts b
  puts

  x = 0
  a, b, c = b, (x += 1), (b += 1)
  puts a
  puts b
  puts c
  puts x
end