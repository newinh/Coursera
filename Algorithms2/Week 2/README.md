# Minimum Spanning Tree

## Minimum Spanning Tree

### prime algorithm

- basic implementation
- lazy implementation
- eager implementation


#### indexed priority queue


## Shortest paths

### APIs
- DirectedEdge
- EdgeWeightedDigraph
- SP (Short Path)

### Shortest Path Properties

- Edge Relaxation
- optimality conditions

### Dijkstra's Algorithm

### Edge-Weighted DAGs

### Negative Weight

- Dijkstra doesn't work on negative weight directed graph
- Bellman-Ford algorithm

### Single source shortest-paths implementation: cost summary
![compareSP](./compareSP)



===============================



See the Assessment Guide for information on how to interpret this report.

ASSESSMENT SUMMARY

Compilation:  PASSED
API:          PASSED

Findbugs:     FAILED (3 warnings)
PMD:          PASSED
Checkstyle:   FAILED (0 errors, 68 warnings)

Correctness:  25/31 tests passed
Memory:       7/7 tests passed
Timing:       6/6 tests passed

Aggregate score: 88.39%
[Compilation: 5%, API: 5%, Findbugs: 0%, PMD: 0%, Checkstyle: 0%, Correctness: 60%, Memory: 10%, Timing: 20%]

ASSESSMENT DETAILS

The following files were submitted:
----------------------------------
11K Nov 11 19:59 SeamCarver.java


********************************************************************************
*  COMPILING
********************************************************************************


% javac SeamCarver.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
SeamCarver:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS
********************************************************************************


% findbugs *.class
*-----------------------------------------------------------
L D SA_FIELD_DOUBLE_ASSIGNMENT SA: Contains a redundant assignment of the variable 'picture', which serves no purpose.  At SeamCarver.java:[line 293]
L D SA_FIELD_DOUBLE_ASSIGNMENT SA: Contains a redundant assignment of the variable 'picture', which serves no purpose.  At SeamCarver.java:[line 334]
L P UPM_UNCALLED_PRIVATE_METHOD UPM: The private method 'colorSpliter()' is never called.  At SeamCarver.java:[lines 37-49]
Warnings generated: 3


================================================================


...
Checkstyle ends with 0 errors and 65 warnings.

% custom checkstyle checks for SeamCarver.java
*-----------------------------------------------------------
[WARN] SeamCarver.java:40:39: The numeric literal '24' appears to be unnecessary. [NumericLiteral]
[WARN] SeamCarver.java:41:35: The numeric literal '24' appears to be unnecessary. [NumericLiteral]
[WARN] SeamCarver.java:41:39: The numeric literal '32' appears to be unnecessary. [NumericLiteral]
Checkstyle ends with 0 errors and 3 warnings.


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of SeamCarver
*-----------------------------------------------------------
Running 31 total tests.

Test 1a: check energy() with file inputs
* 6x5.png
* 4x6.png
* 10x12.png
* 3x7.png
* 5x6.png
* 7x3.png
* 7x10.png
* 12x10.png
* stripes.png
* diagonals.png
* chameleon.png
* HJoceanSmall.png
* 1x8.png
* 8x1.png
* 1x1.png
==> passed

Test 1b: check energy() with random W-by-H pictures
* 4-by-6
* 5-by-5
* 6-by-4
* 7-by-10
* 250-by-250
==> passed

Test 1c: check energy() with random W-by-H pictures in which
the RGB values of each pixel are in a small range
* 4-by-6
* 5-by-5
* 6-by-4
* 7-by-10
* 250-by-250
==> passed

Test 2a: check width() with file inputs
* 6x5.png
* 4x6.png
==> passed

Test 2b: check width() with random W-by-H pictures
* 4-by-6
* 5-by-5
* 6-by-4
* 7-by-10
==> passed

Test 3a: check height() with file inputs
* 6x5.png
* 4x6.png
==> passed

Test 3b: check height() with random W-by-H pictures
* 4-by-6
* 5-by-5
* 6-by-4
* 7-by-10
==> passed

Test 4a: check findVerticalSeam() with file inputs
* 6x5.png
* 4x6.png
* 10x12.png
* 3x7.png
* 5x6.png
* 7x3.png
* 7x10.png
* 12x10.png
* stripes.png
* diagonals.png
* chameleon.png
* HJoceanSmall.png
* 1x8.png
* 8x1.png
* 1x1.png
==> passed

Test 4b: check findVerticalSeam() with random W-by-H pictures
* 4-by-6
* 5-by-5
* 6-by-4
* 7-by-10
* 250-by-250
==> passed

Test 4c: check findVerticalSeam() with random W-by-H pictures in which
the RGB values of each pixel are in a small range
* 4-by-6
* 5-by-5
* 6-by-4
* 7-by-10
* 250-by-250
==> passed

Test 5a: check findHorizontalSeam() with file inputs
* 6x5.png
* 4x6.png
* 10x12.png
* 3x7.png
* 5x6.png
* 7x3.png
* 7x10.png
* 12x10.png
* stripes.png
* diagonals.png
* chameleon.png
* HJoceanSmall.png
* 1x8.png
* 8x1.png
* 1x1.png
==> passed

Test 5b: check findHorizontalSeam() with random W-by-H pictures
* 4-by-6
* 5-by-5
* 6-by-4
* 7-by-10
* 250-by-250
==> passed

Test 5c: check findHorizontalSeam() with random W-by-H pictures in which
the RGB values of each pixel are in a small range
* 4-by-6
* 5-by-5
* 6-by-4
* 7-by-10
* 250-by-250
==> passed

Test 6a: check removeVerticalSeam() with file inputs and optimal seams
* 6x5.png
* 10x12.png
* 3x7.png
* 5x6.png
* 7x3.png
* 7x10.png
* 12x10.png
* stripes.png
* diagonals.png
* chameleon.png
* HJoceanSmall.png
* 8x1.png
==> passed

Test 6b: check removeVerticalSeam() with random W-by-H pictures and optimal seams
* 4-by-6
* 5-by-5
* 6-by-4
* 7-by-10
* 250-by-250
==> passed

Test 6c: check removeVerticalSeam() with file inputs and random seams
* 6x5.png
* 10x12.png
* 3x7.png
* 5x6.png
* 7x3.png
* 7x10.png
* 12x10.png
* stripes.png
* diagonals.png
* chameleon.png
* HJoceanSmall.png
* 8x1.png
==> passed

Test 6d: check removeVerticalSeam() with random W-by-H pictures and random seams
* 4-by-6
* 5-by-5
* 6-by-4
* 7-by-10
* 250-by-250
==> passed

Test 7a: check removeHorizontalSeam() with file inputs and optimal seams
* 6x5.png
* 10x12.png
* 3x7.png
* 5x6.png
* 7x3.png
* 7x10.png
* 12x10.png
* stripes.png
* diagonals.png
* chameleon.png
* HJoceanSmall.png
* 1x8.png
==> passed

Test 7b: check removeHorizontalSeam() with random W-by-H pictures and optimal seams
* 4-by-6
* 5-by-5
* 6-by-4
* 7-by-10
* 250-by-250
==> passed

Test 7c: check removeHorizontalSeam() with file inputs and random seams
* 6x5.png
* 10x12.png
* 3x7.png
* 5x6.png
* 7x3.png
* 7x10.png
* 12x10.png
* stripes.png
* diagonals.png
* chameleon.png
* HJoceanSmall.png
* 1x8.png
==> passed

Test 7d: check removeHorizontalSeam() with random W-by-H pictures and random seams
* 4-by-6
* 5-by-5
* 6-by-4
* 7-by-10
* 250-by-250
==> passed

Test 8: check that energy(x, y) thows an exception when (x, y) are out of bounds
* picture = 6x5.png, (x, y) = (-1, 4)
- fails to throw an exception when calling energy(-1, 4)

* picture = 6x5.png, (x, y) = (6, 4)
- fails to throw an exception when calling energy(6, 4)

* picture = 6x5.png, (x, y) = (5, 5)
- fails to throw an exception when calling energy(5, 5)

* picture = 6x5.png, (x, y) = (4, -1)
* picture = 6x5.png, (x, y) = (4, 5)
==> FAILED

Test 9a: check removeVerticalSeam() with invalid seam
* picture = 10x10.png
- fails to throw an exception when calling removeVerticalSeam() with an invalid seam
- failed on trial 5 of 100
- distance between pixel 6 and pixel 7 is 2
- invalid seam = [ suppresed (10 entries) ]

* picture = 3x7.png
- fails to throw an exception when calling removeVerticalSeam() with an invalid seam
- failed on trial 1 of 100
- distance between pixel 5 and pixel 6 is 2
- invalid seam = { 1, 0, 1, 2, 1, 2, 0 }

* picture = 7x3.png
- fails to throw an exception when calling removeVerticalSeam() with an invalid seam
- failed on trial 1 of 100
- distance between pixel 1 and pixel 2 is 2
- invalid seam = { 1, 1, 3 }

* picture = 10x12.png
- fails to throw an exception when calling removeVerticalSeam() with an invalid seam
- failed on trial 3 of 100
- distance between pixel 6 and pixel 7 is 2
- invalid seam = [ suppresed (12 entries) ]

* picture = 12x10.png
- fails to throw an exception when calling removeVerticalSeam() with an invalid seam
- failed on trial 1 of 100
- distance between pixel 2 and pixel 3 is 2
- invalid seam = [ suppresed (10 entries) ]

* picture = 1x8.png
* picture = 8x1.png
* picture = 1x1.png
==> FAILED

Test 9b: check removeHorizontalSeam() with invalid seam
* picture = 10x10.png
- fails to throw an exception when calling removeHorizontalSeam() with an invalid seam
- failed on trial 1 of 100
- distance between pixel 4 and pixel 5 is 2
- invalid seam = [ suppresed (10 entries) ]

* picture = 3x7.png
- fails to throw an exception when calling removeHorizontalSeam() with an invalid seam
- failed on trial 4 of 100
- distance between pixel 1 and pixel 2 is 2
- invalid seam = { 4, 4, 2 }

* picture = 7x3.png
- fails to throw an exception when calling removeHorizontalSeam() with an invalid seam
- failed on trial 1 of 100
- distance between pixel 4 and pixel 5 is 2
- invalid seam = { 1, 2, 2, 2, 2, 0, 0 }

* picture = 10x12.png
- fails to throw an exception when calling removeHorizontalSeam() with an invalid seam
- failed on trial 1 of 100
- distance between pixel 0 and pixel 1 is 2
- invalid seam = [ suppresed (10 entries) ]

* picture = 12x10.png
- fails to throw an exception when calling removeHorizontalSeam() with an invalid seam
- failed on trial 1 of 100
- distance between pixel 3 and pixel 4 is 2
- invalid seam = [ suppresed (12 entries) ]

* picture = 1x8.png
* picture = 8x1.png
* picture = 1x1.png
==> FAILED

Test 9c: check removeHorizontalSeam() and removeVerticalSeam() with null arguments
* picture = 6x5.png
* picture = 3x7.png
==> passed

Test 10a: check that client can mutate the Picture object that is passed to the constructor
- picture() returns a reference to argument picture
==> FAILED

Test 10b: check that client can mutate the Picture object that is returned by picture()
- repeated calls to picture() return reference to same Picture object
==> FAILED

Test 11: check constructor with null argument
- fails to throw an exception when calling constructor with a null argument

==> FAILED

Test 12a: check intermixed calls to findHorizontalSeam(), findVerticalSeam(),
removeHorizontalSeam(), and removeVerticalSeam(), width(), height(),
energy(), and picture() made with probabilities p1, p2, p3, p4, p5,
p6, p7, and p8, respectively with optimal seams
* random 5-by-6 image with p = (0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5)
* random 6-by-5 image with p = (0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.5)
* random 8-by-8 image with p = (0.1, 0.1, 0.2, 0.2, 0.0, 0.0, 0.0, 0.4)
* random 8-by-8 image with p = (0.2, 0.2, 0.0, 0.0, 0.2, 0.2, 0.2, 0.0)
* random 8-by-8 image with p = (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.1, 0.1)
* random 100-by-110 image with p = (0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5)
* random 110-by-100 image with p = (0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.5)
* random 110-by-110 image with p = (0.1, 0.1, 0.2, 0.2, 0.0, 0.0, 0.0, 0.4)
* random 100-by-100 image with p = (0.2, 0.2, 0.0, 0.0, 0.1, 0.1, 0.2, 0.2)
* random 110-by-110 image with p = (0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.2, 0.2)
==> passed

Test 12b: check intermixed calls to findHorizontalSeam(), findVerticalSeam(),
removeHorizontalSeam(), and removeVerticalSeam(), width(), height(),
energy(), and picture() made with probabilities p1, p2, p3, p4, p5,
p6, p7, and p8, respectively with random seams
* random 5-by-6 image with p = (0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5)
* random 6-by-5 image with p = (0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.5)
* random 8-by-8 image with p = (0.1, 0.1, 0.2, 0.2, 0.0, 0.0, 0.0, 0.4)
* random 8-by-8 image with p = (0.2, 0.2, 0.0, 0.0, 0.2, 0.2, 0.2, 0.0)
* random 8-by-8 image with p = (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.1, 0.1)
* random 100-by-110 image with p = (0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5)
* random 110-by-100 image with p = (0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.5)
* random 110-by-110 image with p = (0.1, 0.1, 0.2, 0.2, 0.0, 0.0, 0.0, 0.4)
* random 100-by-100 image with p = (0.2, 0.2, 0.0, 0.0, 0.1, 0.1, 0.2, 0.2)
* random 110-by-110 image with p = (0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.2, 0.2)
==> passed

Test 12c: check intermixed calls to findHorizontalSeam(), findVerticalSeam(),
removeHorizontalSeam(), and removeVerticalSeam(), width(), height(),
energy(), and picture() made with probabilities p1, p2, p3, p4, p5,
p6, p7, and p8, respectively with optimal seams
(tests corner cases when width=1 or height=1)
* random 1-by-8 image with p = (0.1, 0.1, 0.2, 0.0, 0.1, 0.1, 0.2, 0.2)
* random 8-by-1 image with p = (0.1, 0.1, 0.0, 0.2, 0.1, 0.1, 0.2, 0.2)
* random 1-by-1 image with p = (0.2, 0.2, 0.0, 0.0, 0.1, 0.1, 0.2, 0.2)
==> passed


Total: 25/31 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of SeamCarver
*-----------------------------------------------------------
Running 7 total tests.

Memory usage of a SeamCarver after removing 2 horizontal
and 2 vertical seams from a W-by-H image.

Maximum allowed memory is 4x the reference.

W, H       student (bytes)    reference (bytes)
--------------------------------------------------------------
=> passed       10         1840               1840
=> passed       20         2880               2880
=> passed       25         3704               3704
=> passed       40         7360               7360
=> passed       80        25920              25920
=> passed      100        40000              40000
=> passed      200       158408             158408
==> 7/7 tests passed

Total: 7/7 tests passed!

Estimated student   memory (bytes) = 4.00 n^2 - 16.06 n + 1602.00   (R^2 = 1.000)
Estimated reference memory (bytes) = 4.00 n^2 - 16.06 n + 1602.00   (R^2 = 1.000)
================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing SeamCarver
*-----------------------------------------------------------
Running 6 total tests.

Finding (but not removing) 50 seams for a 250-by-250 image
width   height  h-seams  v-seams     find   remove     time
----------------------------------------------------------------
250      250       50        0     true    false     1.17
250      250        0       50     true    false     1.10
250      250       25       25     true    false     0.80
=> PASSED

Removing 50 randomly generated non-optimal seams for a 250-by-250 image
width   height  h-seams  v-seams     find   remove     time
----------------------------------------------------------------
250      250       50        0    false     true     0.16
250      250        0       50    false     true     0.15
250      250       25       25    false     true     0.14
=> PASSED

Finding and removing 50 seams for a 250-by-250 image
width   height  h-seams  v-seams     find   remove     time
----------------------------------------------------------------
250      250       50        0     true     true     0.87
250      250        0       50     true     true     0.85
250      250       25       25     true     true     0.84
=> PASSED

Finding (but not removing) 50 seams for a 500-by-500 image
width   height  h-seams  v-seams     find   remove     time
----------------------------------------------------------------
500      500       50        0     true    false     3.32
500      500        0       50     true    false     3.45
500      500       25       25     true    false     3.38
=> PASSED

Removing 50 randomly generated non-optimal seams for a 500-by-500 image
width   height  h-seams  v-seams     find   remove     time
----------------------------------------------------------------
500      500       50        0    false     true     0.55
500      500        0       50    false     true     0.50
500      500       25       25    false     true     0.55
=> PASSED

Finding and removing 50 seams for a 500-by-500 image
width   height  h-seams  v-seams     find   remove     time
----------------------------------------------------------------
500      500       50        0     true     true     3.76
500      500        0       50     true     true     3.82
500      500       25       25     true     true     3.88
=> PASSED


Total: 6/6 tests passed!


================================================================

