#Control FLow
 
 #if method 1
 grade1=10;
 grade=50
 if grade>50
     puts "you got A"
 else
     puts "you got B"
 end  #This is necessary to show the end of block
 print("\n")
 
 #if method 2
 puts "yes B"
 if grade<=50
 end
 print ("\n")
 
 #if method 3
 grade>50? grade=grade1+grade: grade=grade-grade1
 puts " grade is #{grade}"
 print("\n")

#if method 4
unless grade<=50
  puts "you got A"
else
  puts "you got B"
end
print("\n")

#if elsif
grade =45
if grade>50
    puts "it is A"
elsif grade > 40   #pay attention to elsif (no "e", no space)
    puts "it is B"
else
    puts "it is C"
end
print ("\n")

#multiple selection with case
number = 7
case number
when 1, 3, 5, 7, 9
puts "Odd."
when 0, 2, 4, 6, 8, 10
puts "Even."
else
puts "Number is out of range."
end
print("\n")

#while and until
#while
i=5
while i>0
puts "value of is is: #{i}"
i=i-1
end
print("\n")

#util
i=5
until i==0
puts i
i=i-1
end
print("\n")

#loop
 i = 0
 loop do
   i += 2
   if i == 4
     next #similar to continue
   end
   puts "this is iteration #{i}"
   if i == 10
     break #break the loop
   end
   if i == 8
     redo #similar to continue
   end
   puts "here we reach #{i}"
 end

 i=0;
while i < 3
  if i == 2
    i += 1
    redo
  end
  print "#{i} "
  i += 1
end