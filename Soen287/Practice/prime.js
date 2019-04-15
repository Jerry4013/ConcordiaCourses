function isPrime(number) {
    for (var i = 2; i < Math.floor(Math.sqrt(number)) ; i++) {
        if (number % i === 0){
            return false;
        }
    }
    return true;
}