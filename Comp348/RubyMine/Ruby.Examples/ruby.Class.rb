
class Coordinate   #class name starts with uppercase letter
@@total = 0 #class variable
def initialize (x, y)  #special method for initialization(similar to constructor)
@@total += 1
@x = x   #instance variable
@y = y   #instance variable
end
def to_s
return "(#@x, #@y)"   # using # results in returning the value of x and y
end
def Coordinate.total     #static method
return "Number of coordinates: #@@total"
end
def setx (x)
@x = x
end
def sety (y)
@y = y
end
def getx
@x
end
def gety
@y
end
end
p1=Coordinate.new(0,0) #object creation
puts p1.to_s
puts Coordinate.total
p1.setx(5)
puts p1.to_s
p2 = Coordinate.new(1, 1)
puts p2.to_s
puts Coordinate.total

#defining a subclass

class XYZCoordinate < Coordinate
attr_accessor :z    #another way to define class attributes
@@newtotal = 0  # class variable (static)
def initialize (x, y, z)
super(x, y)
@z = z
@@newtotal += 1
end
def to_s
return "(#{@x}, #{@y}, #{@z})"
end
def XYZCoordinate.total
return "Number of 3D-coordinates: #@@newtotal"
end
end

p1 = XYZCoordinate.new(0,0,0)
puts p1.to_s #=> (0, 0, 0)
p2 = XYZCoordinate.new(1,5,5)
puts p2.to_s #=> (1, 5, 5)
puts XYZCoordinate.total #=> Number of 3D-coordinates: 2
puts Coordinate.total # all the point of XYZCoordinate belong to parent class (Coordinate)
print("\n")

#introspection
ObjectSpace.each_object(Coordinate) { |p|
puts p.inspect
}

