package org.bubbaprog.linearalgebra
class AdamVectorBasicOperations {
	static void main(def args) {
		def vectorOne = new AdamVector(coordinates: [1.111,2])
		def vectorTwo = new AdamVector(coordinates: [3.313,4])
		def vectorAddition = add(vectorOne, vectorTwo)
		def vectorSubtraction = subtract(vectorOne, vectorTwo)
		def vectorScale = scale(vectorOne, 3)
		println "Vector one is ${vectorOne}, and vector two is ${vectorTwo}"
		println "Vector one coordinates are ${vectorOne.coordinates}"
		println "Vector addition result is ${vectorAddition}"
		println "Vector scalar result is ${vectorScale}"
		def vectorThree = new AdamVector(-0.221, 7.437)
		def vectorFour = new AdamVector(8.813, -1.331, -6.247)
		def vectorFive = new AdamVector(5.581, -2.136)
		def vectorSix = new AdamVector(1.996, 3.108, -4.554)
		println("Magnitude of vector $vectorThree.coordinates is ${magnitude(vectorThree)}")
		println("Magnitude of vector $vectorFour.coordinates is ${magnitude(vectorFour)}")
		println("Direction of vector $vectorFive.coordinates is ${direction(vectorFive)}")
		println("Direction of vector $vectorSix.coordinates is ${direction(vectorSix)}")
	}
		
	static AdamVector add(AdamVector vectorOne, AdamVector vectorTwo) {
		if(vectorOne?.coordinates == null || vectorTwo?.coordinates == null) {
			return null
		}
		if(vectorOne.coordinates.length != vectorTwo.coordinates.length) {
			return null
		}
		def coordinatesThree = []
		for(def i = 0; i < vectorOne.coordinates.length; i++) {
			coordinatesThree.push(vectorOne.coordinates[i] + vectorTwo.coordinates[i])
		}
		return coordinatesThree		
	}
	
	static AdamVector subtract(AdamVector vectorOne, AdamVector vectorTwo) {
		if(vectorOne?.coordinates == null || vectorTwo?.coordinates == null) {
			return null
		}
		def negativedCoordinates = vectorTwo.coordinates.collect{it * -1}
		vectorTwo.coordinates = negativedCoordinates
		return add(vectorOne, vectorTwo)
	}
	
	static AdamVector scale(AdamVector vectorOne, def scalar) {
		if(vectorOne?.coordinates == null) {
			return null
		}
		def scaledCoordinates = vectorOne.coordinates.collect{it * scalar}
		AdamVector result = new AdamVector()
		result.coordinates = scaledCoordinates
		return result
	}
	
	static def magnitude(AdamVector vectorOne) {
		if (!vectorOne.coordinates) {
			return null
		}
		def coordinatesSumOfSquares
		vectorOne.coordinates.each{ //square and sum coordinates
			if (coordinatesSumOfSquares != null) {
				coordinatesSumOfSquares += it * it
			} else {
				coordinatesSumOfSquares = it * it
			}
		}
		return Math.sqrt(coordinatesSumOfSquares)
	}
	
	static AdamVector direction(AdamVector vector) {
		if (!vector.coordinates) {
			return null
		}
		def magnitude = magnitude(vector)
		AdamVector result = scale(vector, (1/magnitude))
		return result
	}
	
}
