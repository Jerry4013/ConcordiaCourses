
#Regular Expression Examples
puts /ay/.match('haystack')

name="Flat Wall"
puts (name=~/a/) #returns the index of first occurance of a
if (name=~/e/)
    puts"Yes"
else
    puts"No"
end

#phone number matching

string = "My phone number is (123) 555-1234."
phone_re = /\((\d{3})\)\s+(\d{3})-(\d{4})/
m = phone_re.match(string)
unless m
  puts "There was no match..."
  exit
end
puts m
print("\n")


#file

wordc=0
#read from a file and count the number of words
f = File.open("testfile.txt", "r")
f.each_line do |line|
  puts line
  test=line[/[0-9]+km/]     #pattern matching using regExp
  puts "test is #{test}"
  w=line.split
  w.each { wordc += 1  }
end
puts wordc


#write to the File
f2 =File.open("testfile2.txt","w")
f2.puts "module"
f2.puts " Temp"
f2.puts "3rd line"
f2.puts " printing"
f2.puts "last line"
f2.write "end"
f2.write "end2" #write on the same line
