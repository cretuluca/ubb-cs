% Replace all occurrences of an element from a list with another element e.

replace([], _, _, []).
replace([X | T], X, Y, [Y | R]):-
    !,
    replace(T, X, Y, R).

replace([H | T], X, Y, [H | R]):-
    replace(T, X, Y, R).
