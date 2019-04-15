function computeCost() {
    var french = document.getElementById("french").value;
    var hazlenut = document.getElementById("hazlenut").value;
    var colombian = document.getElementById("colombian").value;
    document.getElementById("cost").value =
      totalCost = french * 3.49 + hazlenut * 3.95 + colombian * 4.59;
}
