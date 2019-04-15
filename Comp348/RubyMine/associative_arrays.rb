class AssociativeArrays
  biblio = {"nabokov89a" => "Pnin",
            "bulgakov96" => "The master and margarita",
            "nabokov89b" => "Invitation to a Beheading",
            "nabokov90"  => "The defense",
            "kafka95"    => "The trial"}
  puts biblio.length
  puts biblio["bulgakov96"]
  biblio["nabokov89a"] = "Lolita"
  puts biblio["nabokov89a"]
  biblio["nietzsche97"] = "Beyond good and evil"
  puts biblio["nietzsche97"]
  puts biblio.length

  biblio.delete_if{|key, value| key == "kafka95"}
  puts biblio
  # biblio.each_pair do |key, value|
  #   puts "#{key} : #{value}"
  # end
  biblio.each {|key, value| puts key + " : " + value}
end