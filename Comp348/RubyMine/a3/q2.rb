# This method counts the characters including 𝑝𝑢𝑛𝑐𝑡𝑢𝑎𝑡𝑖𝑜𝑛.
# If you need a method counting the characters excluding punctuation, remove the "#" in line 27,
# "wordsArray = line.split#(/\W/)" becomes "wordsArray = line.split(/\W/)"
def calcARI(fileName)
  if (fileName.class != String)
    return "The argument is not a valid file name."
  end
  level = ["5-6 (Kindergarten)",
           "6-7 (First/Second Grade)",
           "7-9 (Third Grade)",
           "9-10 (Fourth Grade)",
           "10-11 (Fifth Grade)",
           "11-12 (Sixth Grade)",
           "12-13 (Seventh Grade)",
           "13-14 (Eighth Grade)",
           "14-15 (Ninth Grade)",
           "15-16 (Tenth Grade)",
           "16-17 (Eleventh Grade)",
           "17-18 (Twelfth grade)",
           "18-24 (College student)",
           "24+ (Professor)"]
  file = File.open(fileName)
  characters = 0
  words = 0
  sentences = 0
  file.each do |line|
    wordsArray = line.split#(/\W/)
    wordsArray.each do |word|
      characters += word.length
    end
    words += line.split.size
    sentences += line.split(/\.\s+/).size
  end
  ari = 4.71 * characters / words + 0.5 * words / sentences - 21.43
  puts "Total # of characters: #{characters}"
  puts "Total # of words: #{words}"
  puts "Total # of sentences: #{sentences}"
  printf("Automated Readability Index: %.1f\n", ari)
  score = ari.floor
  puts "Grade level: #{level[score-1]}"
end

calcARI("paragraph.txt")

