tsuma([],0).
tsuma([First|Left],K):-First>0, tsuma(Left,SumOfTail),K is First+SumOfTail.
tsuma([First|Left],K):-tsuma(Left,SumOfTail), K is SumOfTail.

