class InheritanceTest
  attr_accessor :x, :y
  def initialize(x, y)
    @x = x
    @y = y
  end
  def to_s
    return "#{@x}, #{@y}"
  end
end

class SubInheritanceTest < InheritanceTest
  def initialize(x, y, z)
    super(x, y)
    @z = z
  end
  def to_s
    return "#{@x}, #{@y}, #{@z}"
  end
end
t1 = InheritanceTest.new(5,6)
puts t1
t2 = SubInheritanceTest.new(1,2,3)
puts t2

