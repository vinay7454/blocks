package pt314.blocks.game;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import pt314.blocks.gui.SimpleGUI;

public class GameBoardTest {

	private GameBoard testBoard;
	
	@Before
	public void initialize() throws FileNotFoundException {		
		testBoard = SimpleGUI.loadNewPuzzle(1);				
	}

	@Test
	public void testTargetMovement(){
		assertFalse(testBoard.moveBlock(2, 2, Direction.UP, 1));		
	}
	
	@Test
	public void testForOverlapping(){
		testBoard.moveBlock(0, 0, Direction.RIGHT, 3);
		assertFalse(testBoard.moveBlock(0, 3, Direction.UP, 1));
	}
	
	@Test
	public void testHJumpOverV(){
		testBoard.moveBlock(1, 3, Direction.UP, 1);
		assertFalse(testBoard.moveBlock(0, 0, Direction.RIGHT, 4));		
	}
	
	@Test
	public void testVJumpOverH(){
		testBoard.moveBlock(2,2, Direction.LEFT, 1);
		assertFalse(testBoard.moveBlock(3, 1, Direction.UP, 2));		
	}


	@Test
	public void testVOutOfBoundaryUp(){
		assertFalse(testBoard.moveBlock(3, 1, Direction.UP, 4));	
	}
	
	@Test
	public void testVOutOfBoundaryDown(){
		assertFalse(testBoard.moveBlock(3, 1, Direction.DOWN, 2));	
	}
	
	@Test
	public void testHOutOfBoundaryRight(){
		assertFalse(testBoard.moveBlock(0, 0, Direction.RIGHT, 5));	
	}
	
	@Test
	public void testHOutOfBoundaryLeft(){
		assertFalse(testBoard.moveBlock(4, 4, Direction.LEFT, 5));	
	}

	@Test
	public void testHMovementDown(){
		assertFalse(testBoard.moveBlock(0, 0, Direction.DOWN, 1));
	}
	
	@Test
	public void testHMovementUp(){
		assertFalse(testBoard.moveBlock(0, 0, Direction.UP, 1));
	}
	
	@Test
	public void testVMovementLeft(){
		assertFalse(testBoard.moveBlock(3, 1, Direction.LEFT, 1));		
	}
	
	@Test
	public void testVMovementRight(){
		assertFalse(testBoard.moveBlock(3, 1, Direction.RIGHT, 1));		
	}
	
}