# Documentation

## How to run the program

Type `gradle run --args="[input-file-name] [output-file-name]"`

The program does not support processing of multiple input or output files at the same time.
In order to process multiple inputs, write them one after another in one input file.
The results will also be written one after another in one output file.

#### Example:
`gradle run --args="data/genInput.txt data/genOutput.txt"`

## Format of input data

* Different inputs should be written one after another without any separators
* One input consists of 2 lines: first line is 1 positive number - memory size; second line is a list of requests to the memory separated with spaces

#### Example:
**10**\
**1 2 3 4 5 6 7 8 9 10 2 3 11 15 3 1 2 5 12 13 14 6 5**\
**1**\
**1 2 3 4 1 2 3**\
**100**\
**10 9 8 7 6 5 4 3 2 1**

For more examples check data folder.

## Format of output data

Outputs all steps of each algorithm and prints the number of responses of the second type

#### Example (for input given in the previous example):

**/////////////////////////////////////////////**\
**Input number 1**\
**/////////////////////////////////////////////**\
**FIFO**\
**Frame 1 should be substituted with page 1**\
**Frame 2 should be substituted with page 2**\
**Frame 3 should be substituted with page 3**\
**Frame 4 should be substituted with page 4**\
**Frame 5 should be substituted with page 5**\
**Frame 6 should be substituted with page 6**\
**Frame 7 should be substituted with page 7**\
**Frame 8 should be substituted with page 8**\
**Frame 9 should be substituted with page 9**\
**Frame 10 should be substituted with page 10**\
**Page 2 has already been loaded into memory**\
**Page 3 has already been loaded into memory**\
**Frame 1 should be substituted with page 11**\
**Frame 2 should be substituted with page 15**\
**Page 3 has already been loaded into memory**\
**Frame 3 should be substituted with page 1**\
**Frame 4 should be substituted with page 2**\
**Page 5 has already been loaded into memory**\
**Frame 5 should be substituted with page 12**\
**Frame 6 should be substituted with page 13**\
**Frame 7 should be substituted with page 14**\
**Frame 8 should be substituted with page 6**\
**Frame 9 should be substituted with page 5**\
**Operations of the second type: 19**\
**/////////////////////////////////////////////**\
**LRU**\
**Frame 1 should be substituted with page 1**\
**Frame 2 should be substituted with page 2**\
**Frame 3 should be substituted with page 3**\
**Frame 4 should be substituted with page 4**\
**Frame 5 should be substituted with page 5**\
**Frame 6 should be substituted with page 6**\
**Frame 7 should be substituted with page 7**\
**Frame 8 should be substituted with page 8**\
**Frame 9 should be substituted with page 9**\
**Frame 10 should be substituted with page 10**\
**Page 2 has already been loaded into memory**\
**Page 3 has already been loaded into memory**\
**Frame 1 should be substituted with page 11**\
**Frame 4 should be substituted with page 15**\
**Page 3 has already been loaded into memory**\
**Frame 5 should be substituted with page 1**\
**Page 2 has already been loaded into memory**\
**Frame 6 should be substituted with page 5**\
**Frame 7 should be substituted with page 12**\
**Frame 8 should be substituted with page 13**\
**Frame 9 should be substituted with page 14**\
**Frame 10 should be substituted with page 6**\
**Page 5 has already been loaded into memory**\
**Operations of the second type: 18**\
**/////////////////////////////////////////////**\
**OPT**\
**Frame 1 should be substituted with page 1**\
**Frame 2 should be substituted with page 2**\
**Frame 3 should be substituted with page 3**\
**Frame 4 should be substituted with page 4**\
**Frame 5 should be substituted with page 5**\
**Frame 6 should be substituted with page 6**\
**Frame 7 should be substituted with page 7**\
**Frame 8 should be substituted with page 8**\
**Frame 9 should be substituted with page 9**\
**Frame 10 should be substituted with page 10**\
**Page 2 has already been loaded into memory**\
**Page 3 has already been loaded into memory**\
**Frame 4 should be substituted with page 11**\
**Frame 7 should be substituted with page 15**\
**Page 3 has already been loaded into memory**\
**Page 1 has already been loaded into memory**\
**Page 2 has already been loaded into memory**\
**Page 5 has already been loaded into memory**\
**Frame 1 should be substituted with page 12**\
**Frame 2 should be substituted with page 13**\
**Frame 3 should be substituted with page 14**\
**Page 6 has already been loaded into memory**\
**Page 5 has already been loaded into memory**\
**Operations of the second type: 15**\
**/////////////////////////////////////////////**\
**Input number 2**\
**/////////////////////////////////////////////**\
**FIFO**\
**Frame 1 should be substituted with page 1**\
**Frame 1 should be substituted with page 2**\
**Frame 1 should be substituted with page 3**\
**Frame 1 should be substituted with page 4**\
**Frame 1 should be substituted with page 1**\
**Frame 1 should be substituted with page 2**\
**Frame 1 should be substituted with page 3**\
**Operations of the second type: 7**\
**/////////////////////////////////////////////**\
**LRU**\
**Frame 1 should be substituted with page 1**\
**Frame 1 should be substituted with page 2**\
**Frame 1 should be substituted with page 3**\
**Frame 1 should be substituted with page 4**\
**Frame 1 should be substituted with page 1**\
**Frame 1 should be substituted with page 2**\
**Frame 1 should be substituted with page 3**\
**Operations of the second type: 7**\
**/////////////////////////////////////////////**\
**OPT**\
**Frame 1 should be substituted with page 1**\
**Frame 1 should be substituted with page 2**\
**Frame 1 should be substituted with page 3**\
**Frame 1 should be substituted with page 4**\
**Frame 1 should be substituted with page 1**\
**Frame 1 should be substituted with page 2**\
**Frame 1 should be substituted with page 3**\
**Operations of the second type: 7**\
**/////////////////////////////////////////////**\
**Input number 3**\
**/////////////////////////////////////////////**\
**FIFO**\
**Frame 1 should be substituted with page 10**\
**Frame 2 should be substituted with page 9**\
**Frame 3 should be substituted with page 8**\
**Frame 4 should be substituted with page 7**\
**Frame 5 should be substituted with page 6**\
**Frame 6 should be substituted with page 5**\
**Frame 7 should be substituted with page 4**\
**Frame 8 should be substituted with page 3**\
**Frame 9 should be substituted with page 2**\
**Frame 10 should be substituted with page 1**\
**Operations of the second type: 10**\
**/////////////////////////////////////////////**\
**LRU**\
**Frame 1 should be substituted with page 10**\
**Frame 2 should be substituted with page 9**\
**Frame 3 should be substituted with page 8**\
**Frame 4 should be substituted with page 7**\
**Frame 5 should be substituted with page 6**\
**Frame 6 should be substituted with page 5**\
**Frame 7 should be substituted with page 4**\
**Frame 8 should be substituted with page 3**\
**Frame 9 should be substituted with page 2**\
**Frame 10 should be substituted with page 1**\
**Operations of the second type: 10**\
**/////////////////////////////////////////////**\
**OPT**\
**Frame 1 should be substituted with page 10**\
**Frame 2 should be substituted with page 9**\
**Frame 3 should be substituted with page 8**\
**Frame 4 should be substituted with page 7**\
**Frame 5 should be substituted with page 6**\
**Frame 6 should be substituted with page 5**\
**Frame 7 should be substituted with page 4**\
**Frame 8 should be substituted with page 3**\
**Frame 9 should be substituted with page 2**\
**Frame 10 should be substituted with page 1**\
**Operations of the second type: 10**
