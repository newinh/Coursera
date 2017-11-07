# WordNet


See the Assessment Guide for information on how to interpret this report.

ASSESSMENT SUMMARY

Compilation:  PASSED
API:          PASSED

Findbugs:     FAILED (3 warnings)
PMD:          PASSED
Checkstyle:   FAILED (0 errors, 122 warnings)

Correctness:  27/35 tests passed
Memory:       4/4 tests passed
Timing:       12/16 tests passed

Aggregate score: 81.29%
[Compilation: 5%, API: 5%, Findbugs: 0%, PMD: 0%, Checkstyle: 0%, Correctness: 60%, Memory: 10%, Timing: 20%]

ASSESSMENT DETAILS

The following files were submitted:
----------------------------------
1.5K Nov  7 09:41 Outcast.java
8.5K Nov  7 09:41 SAP.java
5.5K Nov  7 09:41 WordNet.java


********************************************************************************
*  COMPILING
********************************************************************************


% javac SAP.java
*-----------------------------------------------------------

% javac WordNet.java
*-----------------------------------------------------------

% javac Outcast.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
SAP:

WordNet:

Outcast:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS
********************************************************************************


% findbugs *.class
*-----------------------------------------------------------
H B ES_COMPARING_PARAMETER_STRING_WITH_EQ ES: Compares two strings for reference equality using '==' or '!='. Use the 'equals()' method for object equality (to check whether two strings correspond to the same sequence of characters).  At WordNet.java:[line 92]
M B ES_COMPARING_STRINGS_WITH_EQ ES: Compares two strings for reference equality using '==' or '!='. Use the 'equals()' method for object equality (to check whether two strings correspond to the same sequence of characters).  At WordNet.java:[line 152]
M P SBSC_USE_STRINGBUFFER_CONCATENATION SBSC: Builds a 'String' object using the '+' operator in a loop, which can take time quadratic in the length of the resulting string. Instead, use 'StringBuilder'.  At WordNet.java:[line 152]
Warnings generated: 3


================================================================


% pmd .
*-----------------------------------------------------------
Outcast.java:9: The private instance (or static) variable 'wordNet' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
SAP.java:11: The private instance (or static) variable 'wordNetGraph' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
SAP.java:13: The private instance (or static) variable 'queue' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
SAP.java:20: The private instance (or static) variable 'maxDist' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
WordNet.java:13: Can you replace the instance (or static) variable 'wordNetGraph' with a local variable? [SingularField]
WordNet.java:13: The private instance (or static) variable 'wordNetGraph' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
WordNet.java:14: The private instance (or static) variable 'words' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
WordNet.java:15: The private instance (or static) variable 'sap' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
WordNet.java:92: Use equals() to compare strings instead of '==' or '!=' [UseEqualsToCompareStrings]
WordNet.java:152: Use equals() to compare strings instead of '==' or '!=' [UseEqualsToCompareStrings]
PMD ends with 10 warnings.


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] Outcast.java:3: Do not use .* in import statements. [AvoidStarImport]
[WARN] Outcast.java:25:23: '=' is not preceded with whitespace. [WhitespaceAround]
[WARN] Outcast.java:25:24: '=' is not followed by whitespace. [WhitespaceAround]
[WARN] Outcast.java:25:28: '<' is not preceded with whitespace. [WhitespaceAround]
[WARN] Outcast.java:25:29: '<' is not followed by whitespace. [WhitespaceAround]
[WARN] Outcast.java:35:17: '(' is followed by whitespace. [ParenPad]
[WARN] Outcast.java:35:32: '{' is not preceded with whitespace. [WhitespaceAround]
[WARN] Outcast.java:46:43: '{' is not preceded with whitespace. [WhitespaceAround]
[WARN] SAP.java:5: Do not use .* in import statements. [AvoidStarImport]
[WARN] SAP.java:36:18: The method 'BFS' must start with a lowercase letter and use camelCase. [MethodName]
[WARN] SAP.java:38:23: ';' is preceded with whitespace. [NoWhitespaceBefore]
[WARN] SAP.java:38:45: ';' is preceded with whitespace. [NoWhitespaceBefore]
[WARN] SAP.java:41:23: ';' is preceded with whitespace. [NoWhitespaceBefore]
[WARN] SAP.java:41:46: ';' is preceded with whitespace. [NoWhitespaceBefore]
[WARN] SAP.java:48:33: '{' is not preceded with whitespace. [WhitespaceAround]
[WARN] SAP.java:51:16: 'for' is not followed by whitespace. [WhitespaceAround]
[WARN] SAP.java:53:21: '(' is followed by whitespace. [ParenPad]
[WARN] SAP.java:66:13: '(' is followed by whitespace. [ParenPad]
[WARN] SAP.java:66:49: ')' is preceded with whitespace. [ParenPad]
[WARN] SAP.java:69:13: '(' is followed by whitespace. [ParenPad]
[WARN] SAP.java:69:49: ')' is preceded with whitespace. [ParenPad]
[WARN] SAP.java:74:23: ';' is preceded with whitespace. [NoWhitespaceBefore]
[WARN] SAP.java:74:45: ';' is preceded with whitespace. [NoWhitespaceBefore]
[WARN] SAP.java:77:23: ';' is preceded with whitespace. [NoWhitespaceBefore]
[WARN] SAP.java:77:46: ';' is preceded with whitespace. [NoWhitespaceBefore]
[WARN] SAP.java:87:25: '{' is not preceded with whitespace. [WhitespaceAround]
[WARN] SAP.java:92:32: ')' is preceded with whitespace. [ParenPad]
[WARN] SAP.java:98:17: '(' is followed by whitespace. [ParenPad]
[WARN] SAP.java:98:46: ')' is preceded with whitespace. [ParenPad]
[WARN] SAP.java:106:21: '(' is followed by whitespace. [ParenPad]
[WARN] SAP.java:111:25: '(' is followed by whitespace. [ParenPad]
[WARN] SAP.java:111:42: ')' is preceded with whitespace. [ParenPad]
[WARN] SAP.java:111:44: '{' is not preceded with whitespace. [WhitespaceAround]
[WARN] SAP.java:117:29: '(' is followed by whitespace. [ParenPad]
[WARN] SAP.java:117:76: ')' is preceded with whitespace. [ParenPad]
[WARN] SAP.java:117:78: '{' is not preceded with whitespace. [WhitespaceAround]
[WARN] SAP.java:133:38: '{' is not preceded with whitespace. [WhitespaceAround]
[WARN] SAP.java:135:13: '(' is followed by whitespace. [ParenPad]
[WARN] SAP.java:135:49: ')' is preceded with whitespace. [ParenPad]
...
Checkstyle ends with 0 errors and 122 warnings.


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of SAP
*-----------------------------------------------------------
Running 19 total tests.

Test 1: check length() and ancestor() on fixed digraphs
* digraph1.txt
* digraph2.txt
* digraph3.txt
* digraph4.txt
- failed on trial 40 of 100
- v = 7, w = 2
- student   length   = -1
- reference length   = 6
- student   ancestor = 6
- reference ancestor = 6

* digraph5.txt
- failed on trial 212 of 484
- v = 12, w = 8
- student   length() = 6
- reference length() = 4

* digraph6.txt
* digraph9.txt
- failed on trial 10 of 81
- v = 7, w = 2
- student   length() = 22
- reference length() = 3

==> FAILED

Test 2: check length() and ancestor() on WordNet digraph
* 100 random vertex pairs in digraph-wordnet.txt
==> passed

Test 3: check length() and ancestor() on directed paths
* 5
* 10
* 20
* 50
* 100
==> passed

Test 4: check length() and ancestor() on directed cycles
* 5
* 10
* 20
* 50
* 100
==> passed

Test 5: check length() and ancestor() on complete graphs
* 5
* 10
* 20
* 50
==> passed

Test 6: check length() and ancestor() on tournament digraphs
* 5
ancestor() inconsistent with length()
- failed on trial 7 of 25
- v = 3, w = 2
- student   length   = 1
- distance from 3 to 3 = 0
- distance from 2 to 3 = 2
- student   ancestor = 3
- reference length   = 1
- reference ancestor = 2

* 10
- failed on trial 11 of 100
- v = 6, w = 4
- student   length() = 2
- reference length() = 1

* 20
ancestor() inconsistent with length()
- failed on trial 1 of 400
- v = 12, w = 8
- student   length   = 1
- distance from 12 to 19 = 1
- distance from 8 to 19 = 1
- student   ancestor = 19
- reference length   = 1
- reference ancestor = 8

* 50
- failed on trial 3 of 2500
- v = 12, w = 35
- student   length() = 2
- reference length() = 1

==> FAILED

Test 7: check length() and ancestor() on complete binary trees
* 5
* 10
* 20
* 50
* 100
==> passed

Test 8: check length() and ancestor() on random DAGs
* 5 vertices, 8 edges
- failed on trial 11 of 25
- v = 3, w = 2
- student   length() = 12
- reference length() = 2

- failed on trial 6 of 100

* 10 vertices, 40 edges
- failed on trial 80 of 100
- v = 9, w = 6
- student   length() = 22
- reference length() = 1

- failed on trial 2 of 100

* 20 vertices, 100 edges
- failed on trial 8 of 400
- v = 2, w = 1
- student   length   = -1
- reference length   = 2
- student   ancestor = 19
- reference ancestor = 19

- failed on trial 1 of 100

==> FAILED

Test 9: check length() and ancestor() on random rooted-in DAGs
* 5 vertices, 8 edges
- failed on trial 22 of 25
- v = 3, w = 2
- student   length() = 12
- reference length() = 2

- failed on trial 1 of 100

* 10 vertices, 40 edges
- failed on trial 15 of 100
- v = 7, w = 6
- student   length() = 22
- reference length() = 1

- failed on trial 1 of 100

* 20 vertices, 100 edges
- failed on trial 4 of 400
- v = 7, w = 10
- student   length() = 43
- reference length() = 2

- failed on trial 1 of 100

==> FAILED

Test 10: check length() and ancestor() on random rooted-out DAGs
* 5 vertices, 8 edges
- failed on trial 5 of 25
- v = 3, w = 0
- student   length() = 12
- reference length() = 1

- failed on trial 4 of 100

* 10 vertices, 40 edges
- failed on trial 20 of 100
- v = 2, w = 7
- student   length() = 22
- reference length() = 1

- failed on trial 1 of 100

* 20 vertices, 100 edges
- failed on trial 2 of 400
- v = 19, w = 3
- student   length() = 3
- reference length() = 2

- failed on trial 1 of 100

==> FAILED

Test 11: check length() and ancestor() on random rooted-in trees
* 5 vertices
* 10 vertices
* 20 vertices
==> passed

Test 12: check length() and ancestor() on random rooted-out trees
* 5 vertices
- failed on trial 6 of 25
- v = 4, w = 0
- student   length() = 12
- reference length() = 3

- failed on trial 8 of 100

* 10 vertices
- failed on trial 9 of 100
- v = 1, w = 8
- student   length() = 22
- reference length() = 3

- failed on trial 5 of 100

* 20 vertices
- failed on trial 363 of 400
- v = 13, w = 19
- student   length   = 42
- reference length   = -1
- student   ancestor = -1
- reference ancestor = -1

- failed on trial 2 of 100

==> FAILED

Test 13: check length() and ancestor() on random simple digraphs
* 5 vertices, 8 edges
- failed on trial 21 of 25
- v = 0, w = 4
- student   length() = 12
- reference length() = 1

- failed on trial 1 of 100

* 10 vertices, 40 edges
ancestor() inconsistent with length()
- failed on trial 1 of 100
- v = 7, w = 5
- student   length   = 1
- distance from 7 to 7 = 0
- distance from 5 to 7 = 2
- student   ancestor = 7
- reference length   = 1
- reference ancestor = 5

- failed on trial 1 of 100

* 20 vertices, 100 edges
- failed on trial 5 of 400
- v = 18, w = 14
- student   length() = 3
- reference length() = 2

- failed on trial 1 of 100

==> FAILED

Test 14: check whether two SAP objects can be created at the same time
* digraph1.txt and digraph2.txt
* digraph3.txt and digraph4.txt
* digraph5.txt and digraph6.txt
* digraph2.txt and digraph1.txt
==> passed

Test 15: check whether SAP is immutable
* digraph1.txt
* digraph2.txt
* digraph3.txt
* digraph4.txt
* digraph5.txt
* digraph6.txt
* digraph-ambiguous-ancestor.txt
==> passed

Test 16: check invalid arguments to length() and ancestor() in digraph1.txt
* v = -1, w = 0
* v = 0, w = -1
* v = 13, w = 0
* v = 0, w = 13
* v = -1 2 4 7 8 9 10 , w = 5 6 11
* v = 2 4 7 8 9 10 , w = -1 5 6 11
* v = 13 2 4 7 8 9 10 , w = 5 6 11
* v = 2 4 7 8 9 10 , w = 13 5 6 11
==> passed

Test 17: check length() and ancestor() with Iterable arguments
* 100 random subsets of 1 and 1 vertices in digraph-wordnet.txt
* 100 random subsets of 1 and 2 vertices in digraph-wordnet.txt
* 100 random subsets of 2 and 1 vertices in digraph-wordnet.txt
* 100 random subsets of 2 and 2 vertices in digraph-wordnet.txt
* 100 random subsets of 3 and 11 vertices in digraph-wordnet.txt
* 100 random subsets of 11 and 3 vertices in digraph-wordnet.txt
* 100 random subsets of 0 and 5 vertices in digraph-wordnet.txt
* 100 random subsets of 5 and 0 vertices in digraph-wordnet.txt
* 100 random subsets of 0 and 0 vertices in digraph-wordnet.txt
==> passed

Test 18: Check Iterable version of length() and ancestor() with null arguments
==> passed

Test 19: random calls to both version of length() and ancestor(),
with probabilities p1 and p2, respectively
* random calls in a random rooted DAG (20 vertices, 100 edges)
(p1 = 0.5, p2 = 0.5)
- ancestor() is not ancestor on shortest ancestral path
- failed on call 64 to ancestor()
- v = 8, w = 19
- student   ancestor = 4
- distance from 8 to 4 = 1
- distance from 19 to 4 = 2
- reference ancestor = 19
- reference length   = 2

* random calls in a random digraph (20 vertices, 100 edges)
(p1 = 0.5, p2 = 0.5)
- ancestor() is not ancestor on shortest ancestral path
- failed on call 9 to ancestor()
- v = 6 10 12 18
- w = 5 11 15 16
- student   ancestor = 6
- distance from v to 6 = 0
- distance from w to 6 = 2
- reference ancestor = 11
- reference length   = 1

==> FAILED


Total: 11/19 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference SAP)
********************************************************************************

Testing correctness of WordNet
*-----------------------------------------------------------
Running 14 total tests.

Test 1: check distance() with random noun pairs
* 1000 pairs using synsets = synsets.txt; hypernyms = hypernyms.txt
==> passed

Test 2: check distance() with all noun pairs
* synsets = synsets15.txt; hypernyms = hypernyms15Path.txt
* synsets = synsets15.txt; hypernyms = hypernyms15Tree.txt
* synsets = synsets6.txt; hypernyms = hypernyms6TwoAncestors.txt
* synsets = synsets11.txt; hypernyms = hypernyms11AmbiguousAncestor.txt
* synsets = synsets8.txt; hypernyms = hypernyms8ModTree.txt
* synsets = synsets8.txt; hypernyms = hypernyms8WrongBFS.txt
* synsets = synsets11.txt; hypernyms = hypernyms11ManyPathsOneAncestor.txt
* synsets = synsets8.txt; hypernyms = hypernyms8ManyAncestors.txt
==> passed

Test 3: check distance() with random noun pairs
* 1000 pairs using synsets = synsets100-subgraph.txt; hypernyms = hypernyms100-subgraph.txt
* 1000 pairs using synsets = synsets500-subgraph.txt; hypernyms = hypernyms500-subgraph.txt
* 1000 pairs using synsets = synsets1000-subgraph.txt; hypernyms = hypernyms1000-subgraph.txt
==> passed

Test 4: check sap() with random noun pairs
* 1000 pairs using synsets = synsets.txt; hypernyms = hypernyms.txt
==> passed

Test 5: check sap() with all noun pairs
* synsets = synsets15.txt; hypernyms = hypernyms15Path.txt
* synsets = synsets15.txt; hypernyms = hypernyms15Tree.txt
* synsets = synsets6.txt; hypernyms = hypernyms6TwoAncestors.txt
* synsets = synsets11.txt; hypernyms = hypernyms11AmbiguousAncestor.txt
* synsets = synsets8.txt; hypernyms = hypernyms8ModTree.txt
* synsets = synsets8.txt; hypernyms = hypernyms8WrongBFS.txt
* synsets = synsets11.txt; hypernyms = hypernyms11ManyPathsOneAncestor.txt
* synsets = synsets8.txt; hypernyms = hypernyms8ManyAncestors.txt
==> passed

Test 6: check sap() with random noun pairs
* 1000 pairs using synsets = synsets100-subgraph.txt; hypernyms = hypernyms100-subgraph.txt
* 1000 pairs using synsets = synsets500-subgraph.txt; hypernyms = hypernyms500-subgraph.txt
* 1000 pairs using synsets = synsets1000-subgraph.txt; hypernyms = hypernyms1000-subgraph.txt
==> passed

Test 7: check whether WordNet is immutable
* synsets = synsets.txt; hypernyms = hypernyms.txt
==> passed

Test 8: check constructor when input is not a rooted DAG
* synsets3.txt, hypernyms3InvalidTwoRoots.txt
* synsets3.txt, hypernyms3InvalidCycle.txt
* synsets6.txt, hypernyms6InvalidTwoRoots.txt
* synsets6.txt, hypernyms6InvalidCycle.txt
* synsets6.txt, hypernyms6InvalidCycle+Path.txt
==> passed

Test 9: check isNoun()
* synsets = synsets.txt; hypernyms = hypernyms.txt
* synsets = synsets15.txt; hypernyms = hypernyms15Path.txt
* synsets = synsets8.txt; hypernyms = hypernyms8ModTree.txt
==> passed

Test 10: check nouns()
* synsets = synsets.txt; hypernyms = hypernyms.txt
* synsets = synsets15.txt; hypernyms = hypernyms15Path.txt
* synsets = synsets8.txt; hypernyms = hypernyms8ModTree.txt
==> passed

Test 11: check whether two WordNet objects can be created at the same time
* synsets1 = synsets15.txt; hypernyms1 = hypernyms15Tree.txt
synsets2 = synsets15.txt; hypernyms2 = hypernyms15Path.txt
* synsets1 = synsets.txt; hypernyms1 = hypernyms.txt
synsets2 = synsets15.txt; hypernyms2 = hypernyms15Path.txt
==> passed

Test 12: call distance() and sap() with invalid arguments
* synsets15.txt, hypernyms15Tree.txt, nounA = "x", nounB = "b"
* synsets15.txt, hypernyms15Tree.txt, nounA = "b", nounB = "x"
* synsets15.txt, hypernyms15Tree.txt, nounA = "x", nounB = "a"
* synsets15.txt, hypernyms15Tree.txt, nounA = "x", nounB = "x"
* synsets15.txt, hypernyms15Tree.txt, nounA = "a", nounB = null
* synsets15.txt, hypernyms15Tree.txt, nounA = null, nounB = "a"
* synsets15.txt, hypernyms15Tree.txt, nounA = null, nounB = null
* synsets15.txt, hypernyms15Tree.txt, nounA = "x", nounB = null
* synsets15.txt, hypernyms15Tree.txt, nounA = null, nounB = "x"
==> passed

Test 13: call isNoun() with a null argument
* synsets15.txt, hypernyms15Path.txt
==> passed

Test 14: random calls to isNoun(), distance(), and sap(), with
probabilities p1, p2, and p3, respectively
* 100 random calls (p1 = 0.5, p2 = 0.5, p3 = 0.0)
* 100 random calls (p1 = 0.5, p2 = 0.0, p3 = 0.5)
* 100 random calls (p1 = 0.0, p2 = 0.5, p3 = 0.5)
* 100 random calls (p1 = 0.2, p2 = 0.4, p3 = 0.4)
==> passed


Total: 14/14 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference SAP and WordNet)
********************************************************************************

Testing correctness of Outcast
*-----------------------------------------------------------
Running 2 total tests.

Test 1: check outcast() on WordNet digraph
(synsets.txt and hypernyms.txt)
* outcast2.txt
* outcast3.txt
* outcast4.txt
* outcast5.txt
* outcast5a.txt
* outcast7.txt
* outcast8.txt
* outcast8a.txt
* outcast8b.txt
* outcast8c.txt
* outcast9.txt
* outcast9a.txt
* outcast10.txt
* outcast10a.txt
* outcast11.txt
* outcast12.txt
* outcast12a.txt
* outcast17.txt
* outcast20.txt
* outcast29.txt
==> passed

Test 2: check outcast() on WordNet subgraph
(synsets50000-subgraph.txt and hypernyms50000-subgraph.txt)
* outcast2.txt
* outcast3.txt
* outcast5.txt
* outcast5a.txt
* outcast7.txt
* outcast8.txt
* outcast8b.txt
* outcast8c.txt
* outcast9.txt
* outcast10.txt
* outcast11.txt
==> passed


Total: 2/2 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of SAP
*-----------------------------------------------------------
Running 1 total tests.

digraph G             = digraph-wordnet.txt
vertices in G         = 82192
edges    in G         = 84505
student     memory    = 9169952 bytes
reference   memory    = 10320400 bytes
ratio                 = 0.89
maximum allowed ratio = 2.50

Total: 1/1 tests passed!

================================================================



Analyzing memory of WordNet
*-----------------------------------------------------------
Running 3 total tests.

Test 1a: check memory of WordNet object
* synsets = synsets1000-subgraph.txt; hypernyms = hypernyms1000-subgraph.txt
- number of vertices in digraph = 1000
- number of edges    in digraph = 1008
- student   memory              = 970808 bytes
- reference memory              = 1494080 bytes
- student / reference ratio     = 0.6
- maximum allowed rato          = 2.0

==> passed

Test 1b: check memory of WordNet object
* synsets = synsets5000-subgraph.txt; hypernyms = hypernyms5000-subgraph.txt
- number of vertices in digraph = 5000
- number of edges    in digraph = 5059
- student   memory              = 4751992 bytes
- reference memory              = 7296384 bytes
- student / reference ratio     = 0.7
- maximum allowed rato          = 2.0

==> passed

Test 1c: check memory of WordNet object
* synsets = synsets10000-subgraph.txt; hypernyms = hypernyms10000-subgraph.txt
- number of vertices in digraph = 10000
- number of edges    in digraph = 10087
- student   memory              = 11199648 bytes
- reference memory              = 16931696 bytes
- student / reference ratio     = 0.7
- maximum allowed rato          = 2.0

==> passed

Total: 3/3 tests passed!

================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing SAP
*-----------------------------------------------------------
Running 7 total tests.

Test 1: time SAP constructor
*  digraph-wordnet.txt
- student solution time =  0.03 seconds
- maximum allowed  time =  1.00 seconds
==> passed

Test 2a-c: time length() and ancestor() with random pairs of vertices
*  digraph-wordnet.txt
- reference solution calls per second:  608760.00
- student   solution calls per second:   23507.33
- reference / student ratio:                25.90

=> passed    student <= 50000x reference
=> passed    student <=  5000x reference
=> passed    student <=   500x reference
=> BONUS     student <=    50x reference

Test 3a-c: time length() and ancestor() with random sets of 5 vertices
*  digraph-wordnet.txt
- reference solution calls per second:  213545.33
- student   solution calls per second:     921.33
- reference / student ratio:               231.78

=> passed    student <= 20000x reference
=> passed    student <=  2000x reference
=> FAILED    student <=   200x reference


Total: 7/7 tests passed!


================================================================



********************************************************************************
*  TIMING (substituting reference SAP)
********************************************************************************

Timing WordNet
*-----------------------------------------------------------
Running 8 total tests.

Test 1: timing WordNet constructor
* synsets = synsets.txt; hypernyms = hypernyms.txt
- student constructor time =  0.98 seconds
- maximum allowed     time = 10.00 seconds
==> passed

Test 2: check that exactly one SAP object created per WordNet object
==> passed

Test 3a-c: timing sap() and distance() with random nouns
* synsets = synsets.txt; hypernyms = hypernyms.txt
- reference solution calls per second:  212573.80
- student   solution calls per second:      56.20
- reference / student ratio:              3782.45

=> passed    student <= 10000x reference
=> FAILED    student <=  1000x reference
=> FAILED    student <=   100x reference
=> FAILED    student <=    10x reference
=> FAILED    student <=     5x reference

Test 4: timing isNoun() with random nouns
* synsets = synsets.txt; hypernyms = hypernyms.txt
- reference solution calls per second:  637464.00
- student   solution calls per second:  592846.00
- reference / student ratio:                 1.08
- allowed ratio:                             4.00
==> passed

Total: 4/8 tests passed!


================================================================



********************************************************************************
*  TIMING (substituting reference SAP and WordNet)
********************************************************************************

Timing Outcast
*-----------------------------------------------------------
Running 1 total tests.

1.07 seconds to build WordNet

Computing time to find outcasts of various outcast files.
Total time must not exceed 1 seconds.

filename       n     time
-----------------------------
outcast4.txt    4     0.00
outcast5.txt    5     0.00
outcast5a.txt    5     0.00
outcast5.txt    5     0.00
outcast7.txt    7     0.00
outcast8.txt    8     0.00
outcast8a.txt    8     0.00
outcast8b.txt    8     0.00
outcast8c.txt    8     0.00
outcast9.txt    9     0.00
outcast9a.txt    9     0.00
outcast10.txt   10     0.00
outcast10a.txt   10     0.00
outcast11.txt   11     0.00
outcast12.txt   12     0.00
outcast12a.txt   12     0.00
outcast20.txt   20     0.00
outcast29.txt   29     0.00
=> passed, total elapsed time: 0.02

Total: 1/1 tests passed!


================================================================
