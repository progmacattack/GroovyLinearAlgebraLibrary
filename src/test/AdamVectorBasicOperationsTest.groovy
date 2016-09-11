package test

import org.bubbaprog.linearalgebra.AdamVector
import org.bubbaprog.linearalgebra.AdamVectorBasicOperations
import org.junit.Test;

class AdamVectorBasicOperationsTest {

	@Test
	public void testAddition() {
		def vectorOne = new AdamVector(coordinates: [3, 4, 1])
		def vectorTwo = new AdamVector(coordinates: [-1, 2, 1])
		def expectedAnswer = new AdamVector(coordinates: [2, 6, 2])
		def returnedVector = AdamVectorBasicOperations.add(vectorOne, vectorTwo)
		println "Response: {$returnedVector}"
		assert expectedAnswer == returnedVector
	}
	
	@Test
	public void testSubtraction() {
		def vectorOne = new AdamVector(coordinates: [3, 4, 1])
		def vectorTwo = new AdamVector(coordinates: [-1, 2, 1])
		def expectedAnswer = new AdamVector(coordinates: [4, 2, 0])
		def returnedVector = AdamVectorBasicOperations.subtract(vectorOne, vectorTwo)
		println "Response: {$returnedVector}"
		assert expectedAnswer == returnedVector
	}
	
	@Test
	public void testScale() {
		def vectorOne = new AdamVector(coordinates: [2, 5])
		def scalar = 3
		def expectedAnswer = new AdamVector(coordinates: [6, 15])
		def returnedVector = AdamVectorBasicOperations.scale(vectorOne, scalar)
		println "Response: ${returnedVector}"
		assert expectedAnswer == returnedVector
	}
	
	@Test
	public void testNullCoordinates() {
		def nullCoordinateVectorOne = new AdamVector()
		def nullCordintateVectorTwo = new AdamVector()
		def returnedVector = AdamVectorBasicOperations.add(nullCoordinateVectorOne, nullCordintateVectorTwo)
		assert returnedVector == null
		def returnedVectorSubtract = AdamVectorBasicOperations.subtract(nullCoordinateVectorOne, nullCordintateVectorTwo)
		assert returnedVectorSubtract == null
		def returnedVectorScale = AdamVectorBasicOperations.scale(nullCoordinateVectorOne, 3)
		assert returnedVectorScale == null
	}

}
