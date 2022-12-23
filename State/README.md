# State Design Pattern
Program validates if an input statement (string) satisfies the gramma:
G = <	{ a, b, c },
  { Start, A, B, C },
  {	Start ->	aA | bC,
    A	    ->	aA | bB | ε,
    B	    ->	bB | a | ε,
    C	    ->	cB | aC | ε },
  Start >

Graph representation:
![My Image](images/graph.jpg)
