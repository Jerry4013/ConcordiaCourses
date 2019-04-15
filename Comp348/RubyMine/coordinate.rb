module Debugger
  def reflect
    "#{self.class.name} (\##{self.object_id}): #{self.to_s}"
  end
end

class Coordinate
  include Debugger
  attr_accessor :x, :y
  @@total = 0
  def initialize (x, y)
    @@total += 1
    @x = x
    @y = y
  end

  def setx (x)
    @x = x
  end
  def sety=(y)
    @y = y
  end
  def getx
    @x
  end
  def gety
    @y
  end
  def to_s
    return "(#@x, #@y)"
  end
end



