class Movie
  @@howmany = 0
  def initialize(title, year)
    @title = title
    @year = year
    @@howmany += 1
  end

  def Movie.total
    return "Number of movies: #@@howmany"
  end
  def to_s
    return "Movie: " + @title + " (" + @year + ")"
  end
end

module MathLibrary
  PI = 3.1415926
  def MathLibrary.factorial(n)
    if n == 0
      1
    else
      n * factorial(n-1)
    end
  end
end

class MyClass2
  def initialize(a,b)
    @a = a
    @b = b
  end
  def to_s
    return "a = #@a, b = #@b"
  end
end

m1 = Movie.new("Taxi driver", "1976")
m2 = Movie.new("The Deer Hunter", "1978")
m3 = Movie.new("Once upon a time in America", "1984")
n = MyClass2.new(4, 5)
puts n.to_s

a = [m1,m2, m3]
puts a.class
puts a.length
puts a[0].to_s
ObjectSpace.each_object(Movie) {|x| puts x.to_s}
puts Movie.total

puts MathLibrary::PI
puts MathLibrary.factorial(5)
puts Math.sqrt(9)
