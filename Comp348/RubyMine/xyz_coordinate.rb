require './coordinate.rb'
class XYZCoordinate < Coordinate

  attr_accessor :z
  @@newtotal = 0
  def initialize (x, y, z)
    super(x, y)
    @z = z
    @@newtotal += 1
  end
  def to_s
    return  "(#{@x}, #{@y}, #{@z})"
  end
  def XYZCoordinate.total
    return "Number of 3D-coordinates: #@@newtotal"
  end
end

p1 = Coordinate.new(0,0)
p2 = XYZCoordinate.new(2,2,5)
def p2.whatIam
  return "The origin on the 3D system."
end
# puts p1
# puts p2
# puts p2.whatIam
# ObjectSpace.each_object(Coordinate){ |p| puts p.inspect}
# ObjectSpace.each_object(Coordinate){ |p| puts p.reflect}
# puts p1.__id__
# puts p1.class
# puts p2.class
# print p2.instance_variables
print p2.instance_variables


