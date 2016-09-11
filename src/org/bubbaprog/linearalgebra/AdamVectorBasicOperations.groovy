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
		vectorOne.coordinates = scaledCoordinates
		return vectorOne
	}
	
}
