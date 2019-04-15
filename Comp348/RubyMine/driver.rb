require "./xyz_coordinate.rb"
require './coordinate.rb'
class Driver
  p1 = XYZCoordinate.new(0,0,0)
  p1.x = 6
  puts p1.to_s
  p2 = XYZCoordinate.new(1,5,5)
  puts p2.to_s
  puts XYZCoordinate.total
end