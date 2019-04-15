class Time


  def initialize (hour,minutes, seconds)
    @hour=hour
    @minutes=minutes
    @seconds=seconds
  end

#test overloading
#def initialize (hour)
#   @hour=hour
#  @minutes=1
#    @seconds=1
#end


  def sethour (hour)
    @hour = hour
  end
  def setminutes (minutes)
    @minutes = minutes
  end
  def gethour
    @hour
  end
  def getminutes
    @minutes
  end
  def setseconds (seconds)
    @seconds = second
  end
  def getseconds
    @seconds
  end

end


class LunchTime < Time
  attr_accessor :lunchhour, :hour  # by using attr_accessor you do not need setter and getter for lunchhour, even for the hour in the parrent class that was private before

  def initialize (hour,minutes, seconds,lunchhour )
    super(hour,minutes, seconds)
    @lunchhour=lunchhour
  end

  def islunchtime
    if(hour==lunchhour)
      return true
    else
      return false
    end
  end
end

#precede accept two objects of parent clsss (Time)
def precede(z,k)
  if(z.gethour<k.gethour)
    return 1
  elsif(z.gethour==k.gethour && z.getminutes<k.getminutes)
    return 1
  elsif(z.getminutes==k.getminutes && z.getseconds<k.getseconds)
    return 1
  else
    return 0
  end
end

#here it accepts two objects of subclass (LunchTime)

def precede2(z,k)
  if(z.hour<k.hour)   # since in LunchTime hour has been public by using attr_accessor
    return 1
  elsif(z.hour==k.hour && z.getminutes<k.getminutes)
    return 1
  elsif(z.getminutes==k.getminutes && z.getseconds<k.getseconds)
    return 1
  else
    return 0
  end
end




t1=Time.new(2,5,6)
#puts t1.hour # this gives error since hour is private
puts t1.gethour

t2=Time.new(2,5,10)

#If t1 is before t2
puts precede(t1,t2)

# puts precede2(t1,t2) #does not work since in parent class hour is private and we need to use gethour(setter)

#creating an abject of subclass
t3=LunchTime.new(2,5,6,2)
t4=LunchTime.new(2,5,4,2)


puts t3. islunchtime()

puts precede2(t3,t4)




