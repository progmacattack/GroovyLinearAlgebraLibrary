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
	
	@Test
	public void testVectorMagnitudeTwoDimensions() {
		def vectorOne = new AdamVector(3, 4)
		def magnitude = AdamVectorBasicOperations.magnitude(vectorOne)
		println("Magnitude of vector $vectorOne.coordinates is $magnitude")
		assert magnitude == 5
	}
	
	@Test
	public void testVectorMagnitudeThreeDimensions() {
		def vectorOne = new AdamVector(3, 4, 5)
		def magnitude = AdamVectorBasicOperations.magnitude(vectorOne)
		println("Magnitude of vector $vectorOne.coordinates is $magnitude")
		assert magnitude > 7.07
		assert magnitude < 7.08
	}
	
	@Test
	public void testVectorMagnitudeNull() {
		def nullVector = new AdamVector()
		def nullReturnVector = AdamVectorBasicOperations.magnitude(nullVector)
		assert nullReturnVector == null
	}
	
	@Test
	public void testVectorDirectionTwoDimensions() {
		def vectorOne = new AdamVector(3,4)
		def resultVector = AdamVectorBasicOperations.direction(vectorOne)
		println("Direction of vector $vectorOne.coordinates is $resultVector.coordinates")
		assert resultVector.coordinates[0] >= 0.6
		assert resultVector.coordinates[0] < 0.601
		assert resultVector.coordinates[1] >= 0.8
		assert resultVector.coordinates[1] < 0.801
	}
	
	@Test
	public void testVectorDirectionThreeDimensions() {
		def vectorOne = new AdamVector(3,4,0.5)
		def resultVector = AdamVectorBasicOperations.direction(vectorOne)
		println("Direction of vector $vectorOne.coordinates is $resultVector.coordinates")
		def answerVector = new AdamVector(0.5,0.666,0.0833)
		assert resultVector.coordinates[0] >= 0.597
		assert resultVector.coordinates[0] < 0.5971
		assert resultVector.coordinates[1] > 0.796
		assert resultVector.coordinates[1] < 0.7961
		assert resultVector.coordinates[2] > 0.0995
		assert resultVector.coordinates[2] < 0.0996
	}
	
	@Test
	public void testVectorDirectionNull() {
		def nullVector = new AdamVector()
		def resultVector = AdamVectorBasicOperations.direction(nullVector)
		assert resultVector == null
	}

}
