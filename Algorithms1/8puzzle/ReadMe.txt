See the Assessment Guide for information on how to interpret this report.

Assessment Summary

Compilation:  PASSED
Style:        FAILED
Findbugs:     Potential bugs found.
API:          PASSED

Correctness:  35/42 tests passed
Memory:       8/8 tests passed
Timing:       17/17 tests passed

Aggregate score: 89.17% [Correctness: 65%, Memory: 10%, Timing: 25%, Style: 0%]

Assessment Details

The following files were submitted:
----------------------------------
total 16K
-rw-r--r-- 1 5.4K Nov  6 19:34 Board.java
-rw-r--r-- 1 3.0K Nov  6 19:34 Solver.java
-rw-r--r-- 1 2.4K Nov  6 19:34 studentSubmission.zip


********************************************************************************
*          COMPILING                                                           *
********************************************************************************


% javac Board.java
*-----------------------------------------------------------

================================================================

% javac Solver.java
*-----------------------------------------------------------

================================================================



% checkstyle *.java
*-----------------------------------------------------------

Checkstyle ends with 167 errors.

================================================================


% findbugs *.class
*-----------------------------------------------------------
M B BC_EQUALS_METHOD_SHOULD_WORK_FOR_ALL_OBJECTS BC: Equals method for Board assumes the argument is of type Board  At Board.java:[line 135]
Warnings generated: 1

================================================================


Testing the APIs of your programs.
*-----------------------------------------------------------
Board:

Solver:

================================================================


******************************************************************************
*          CORRECTNESS
******************************************************************************

Testing methods in Board
*-----------------------------------------------------------
Running 22 total tests.

Tests 5, 6, 13, and 14 rely upon toString() returning results in prescribed format.

Test 1a: Test hamming() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle07.txt
  *  puzzle17.txt
  *  puzzle27.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 1b: Test hamming() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
  *  127-by-127
==> passed

Test 2a: Test manhattan() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle07.txt
  *  puzzle17.txt
  *  puzzle27.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 2b: Test manhattan() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
  *  127-by-127
==> passed

Test 3: Test dimension() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
==> passed

Test 4a: Test toString() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle06.txt
  *  puzzle09.txt
  *  puzzle23.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 4b: Test toString() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
  *  127-by-127
==> passed

Test 5a: Test neighbors() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle06.txt
  *  puzzle09.txt
  *  puzzle23.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 5b: Test neighbors() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
  *  127-by-127
==> passed

Test 6a: Test neighbors() of neigbors() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle06.txt
  *  puzzle09.txt
  *  puzzle23.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 6b: Test neighbors() of neighbors() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
==> passed

Test 7a: Test twin() with file inputs
  *  puzzle04.txt
  *  puzzle00.txt
  *  puzzle06.txt
  *  puzzle09.txt
  *  puzzle23.txt
  *  puzzle2x2-unsolvable1.txt
==> passed

Test 7b: Test twin() with random N-by-N boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  9-by-9
  *  10-by-10
==> passed

Test 8a: Test isGoal() on file inputs
  *  puzzle00.txt
  *  puzzle04.txt
  *  puzzle16.txt
  *  puzzle06.txt
  *  puzzle09.txt
  *  puzzle23.txt
  *  puzzle2x2-unsolvable1.txt
  *  puzzle3x3-unsolvable1.txt
  *  puzzle3x3-00.txt
  *  puzzle4x4-00.txt
==> passed

Test 8b: Test isGoal() on N-by-N goal boards
  *  2-by-2
  *  3-by-3
  *  4-by-4
  *  5-by-5
  *  6-by-6
  *  100-by-100
==> passed

Test 9: Check whether two Board objects can be created at the same time
  *   random 3-by-3 and 3-by-3 boards
  *   random 4-by-4 and 4-by-4 boards
  *   random 2-by-2 and 2-by-2 boards
  *   random 3-by-3 and 4-by-4 boards
  *   random 4-by-4 and 3-by-3 boards
==> passed

Test 10a: Check equals()
  *  reflexive
  *  symmetric
  *  checks that individual entries of array are equal
  *  argument is object of type String
     java.lang.ClassCastException: java.lang.String cannot be cast to Board

     Board.equals(Board.java:135)
     TestBoard.test10a(TestBoard.java:963)
     TestBoard.main(TestBoard.java:1380)

     -  cannot check for equality with a String object
  *  argument is object of type Object
  *  argument is null
     java.lang.NullPointerException

     Board.equals(Board.java:139)
     TestBoard.test10a(TestBoard.java:998)
     TestBoard.main(TestBoard.java:1380)

     -  fails when argument is null
  *  argument is Board of different dimension
     java.lang.ArrayIndexOutOfBoundsException: 3

     Board.equals(Board.java:139)
     TestBoard.test10a(TestBoard.java:1021)
     TestBoard.main(TestBoard.java:1380)

     -  cannot check for equality with a Board of different dimension
==> FAILED

Test 10b: Test equals() on M-by-M vs. N-by-N goal boards
  *  M = 2, N = 2
  *  M = 3, N = 3
  *  M = 4, N = 4
  *  M = 2, N = 5
  *  M = 5, N = 2
     java.lang.ArrayIndexOutOfBoundsException


==> FAILED

Test 11: Check that Board is immutable by changing argument array after
         construction and making sure Board does not mutate
==> passed

Test 12: Check that Board is immutable by testing whether methods
         return the same value, regardless of order in which called
  *  puzzle10.txt
  *  puzzle20.txt
  *  puzzle30.txt
  *  2-by-2
  *  3-by-3
  *  4-by-4
==> passed

Test 13: Call hamming() on a board that is kth-neighbor of a board
  * 0th neighbor of puzzle27.txt
  * 1th neighbor of puzzle27.txt
  * 2th neighbor of puzzle27.txt
  * 13th neighbor of puzzle27.txt
  * 13th neighbor of puzzle00.txt
  * 13th neighbor of puzzle2x2-unsolvable1.txt
==> passed

Test 14: Call manhattan() on a board that is a kth-neighbor of a board
  * 0th neighbor of puzzle27.txt
  * 1th neighbor of puzzle27.txt
  * 2th neighbor of puzzle27.txt
  * 13th neighbor of puzzle27.txt
  * 13th neighbor of puzzle00.txt
  * 13th neighbor of puzzle2x2-unsolvable1.txt
==> passed


Total: 20/22 tests passed!


================================================================

******************************************************************************
*          correctness (substituting reference Board.java)
******************************************************************************

Testing methods in Solver
*-----------------------------------------------------------
Running 20 total tests.

Test 1: Call moves() with file inputs
  *  puzzle00.txt
  *  puzzle01.txt
  *  puzzle02.txt
  *  puzzle03.txt
  *  puzzle04.txt
  *  puzzle05.txt
  *  puzzle06.txt
  *  puzzle07.txt
  *  puzzle08.txt
  *  puzzle09.txt
  *  puzzle10.txt
  *  puzzle11.txt
  *  puzzle12.txt
  *  puzzle13.txt
==> passed

Test 2: Call solution() with file inputs
  *  puzzle00.txt
     java.lang.NullPointerException

     Solver.solution(Solver.java:114)
     TestSolver.testSolution(TestSolver.java:221)
     TestSolver.testSolution(TestSolver.java:212)
     TestSolver.test2(TestSolver.java:303)
     TestSolver.main(TestSolver.java:974)

  *  puzzle01.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
     -  length of solution() = 1
     -  moves()              = 1
  *  puzzle02.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
     -  length of solution() = 2
     -  moves()              = 2
  *  puzzle03.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
     -  length of solution() = 3
     -  moves()              = 3
  *  puzzle04.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
     -  length of solution() = 4
     -  moves()              = 4
  *  puzzle05.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
     -  length of solution() = 5
     -  moves()              = 5
  *  puzzle06.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
     -  length of solution() = 6
     -  moves()              = 6
  *  puzzle07.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
     -  length of solution() = 7
     -  moves()              = 7
  *  puzzle08.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
     -  length of solution() = 8
     -  moves()              = 8
  *  puzzle10.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
     -  length of solution() = 10
     -  moves()              = 10
  *  puzzle15.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
     -  length of solution() = 15
     -  moves()              = 15
==> FAILED

Test 3: Create two Solver objects at the same time
  *  puzzle04.txt and puzzle04.txt
  *  puzzle00.txt and puzzle04.txt
  *  puzzle04.txt and puzzle00.txt
==> passed

Test 4a: Call isSolvable() with file inputs
  *  puzzle01.txt
  *  puzzle03.txt
  *  puzzle04.txt
  *  puzzle17.txt
  *  puzzle3x3-unsolvable1.txt
  *  puzzle3x3-unsolvable2.txt
  *  puzzle4x4-unsolvable.txt
==> passed

Test 4b: Call isSolvable() on random N-by-N puzzles
  *  100 random 2-by-2 boards
==> passed

Test 5: Call moves() on unsolvable puzzles
  *  puzzle2x2-unsolvable1.txt
  *  puzzle2x2-unsolvable2.txt
  *  puzzle3x3-unsolvable1.txt
  *  puzzle3x3-unsolvable2.txt
  *  puzzle4x4-unsolvable.txt
==> passed

Test 6: Call solution() on unsolvable puzzles
  *  puzzle2x2-unsolvable1.txt
  *  puzzle2x2-unsolvable2.txt
  *  puzzle3x3-unsolvable1.txt
  *  puzzle3x3-unsolvable2.txt
  *  puzzle4x4-unsolvable.txt
==> passed

Test 7a: Check that Solver is immutable by testing whether methods
         return the same value, regardless of order in which called
  *  puzzle3x3-00.txt
     java.lang.NullPointerException

     Solver.solution(Solver.java:114)
     TestSolver.testImmutableSolver(TestSolver.java:512)
     TestSolver.testImmutableSolver(TestSolver.java:601)
     TestSolver.test7a(TestSolver.java:609)
     TestSolver.main(TestSolver.java:992)

     -  sequence of Solver operations was:
          Solver solver = new Solver(initial);
          solver.moves() -> 0
          solver.moves() -> 0
          solver.moves() -> 0
          solver.moves() -> 0
          solver.moves() -> 0
          solver.solution()
  *  puzzle3x3-01.txt
  *  puzzle3x3-05.txt
  *  puzzle3x3-10.txt
  *  random 2-by-2 solvable boards
     java.lang.NullPointerException

     Solver.solution(Solver.java:114)
     TestSolver.testImmutableSolver(TestSolver.java:512)
     TestSolver.testImmutableSolverSolvableBoards(TestSolver.java:569)
     TestSolver.test7a(TestSolver.java:613)
     TestSolver.main(TestSolver.java:992)

     -  sequence of Solver operations was:
          Solver solver = new Solver(initial);
          solver.isSolvable() -> true
          solver.moves() -> 0
          solver.solution()
     -  failed on trial 2 of 10

==> FAILED

Test 7b: Check that Solver is immutable by testing whether methods
         return the same value, regardless of order in which called
  *  puzzle3x3-unsolvable1.txt
  *  puzzle3x3-unsolvable2.txt
  *  puzzle4x4-unsolvable.txt
  *  random 2-by-2 unsolvable boards
==> passed

Test 8: Call moves() with more file inputs
  *  puzzle14.txt
  *  puzzle15.txt
  *  puzzle16.txt
  *  puzzle17.txt
  *  puzzle18.txt
  *  puzzle19.txt
  *  puzzle20.txt
  *  puzzle21.txt
  *  puzzle22.txt
  *  puzzle23.txt
  *  puzzle24.txt
  *  puzzle25.txt
  *  puzzle26.txt
  *  puzzle27.txt
  *  puzzle28.txt
  *  puzzle29.txt
  *  puzzle30.txt
  *  puzzle31.txt
==> passed

Test 9: Check whether equals() method in Board is called
        with an argument of the wrong type
  *  puzzle00.txt
     java.lang.NullPointerException

     Solver.solution(Solver.java:114)
     TestSolver.testSolution(TestSolver.java:221)
     TestSolver.testEqualsWrongType(TestSolver.java:664)
     TestSolver.test9(TestSolver.java:680)
     TestSolver.main(TestSolver.java:1001)

  *  puzzle05.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
     -  length of solution() = 5
     -  moves()              = 5
  *  puzzle10.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
     -  length of solution() = 10
     -  moves()              = 10
  *  puzzle15.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
     -  length of solution() = 15
     -  moves()              = 15
==> passed

Test 10: Check that constructor throws exception if board is null
==> passed

Test 11: Check for fragile dependence on toString()
  *  puzzle00.txt
  *  puzzle04.txt
  *  puzzle08.txt
  *  puzzle12.txt
==> passed

Test 12a: Call moves() with 2-by-2 file inputs
  *  puzzle2x2-00.txt
  *  puzzle2x2-01.txt
  *  puzzle2x2-02.txt
  *  puzzle2x2-03.txt
  *  puzzle2x2-04.txt
  *  puzzle2x2-05.txt
  *  puzzle2x2-06.txt
==> passed

Test 12b: Call solution() with 2-by-2 file inputs
  *  puzzle2x2-00.txt
     java.lang.NullPointerException

     Solver.solution(Solver.java:114)
     TestSolver.testSolution(TestSolver.java:221)
     TestSolver.testSolution(TestSolver.java:212)
     TestSolver.test12b(TestSolver.java:768)
     TestSolver.main(TestSolver.java:1013)

  *  puzzle2x2-01.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
     -  length of solution() = 1
     -  moves()              = 1
  *  puzzle2x2-02.txt
     -  number of boards in solution() does not equal to 1 + moves()
        (it should be 1 greater because solution() starts with the inital board)
    

...

Warning: the grading output was truncated due to excessive length.
Typically, this is becasue you have a method that has an unanticipated side effect
(such as printing to standard output or throwing an exception).