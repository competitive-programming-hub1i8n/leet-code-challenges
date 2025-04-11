package org.example.implementations;

public class N_986_IntervalListIntersections {

}

/*
def intervalIntersection(self, lista1: List[List[int]], lista2: List[List[int]]) -> List[List[int]]:
   pila = []
   p1 = 0
   p2 = 0
   while p1 < len(lista1) and p2 < len(lista2):
       low = max(lista1[p1][0],lista2[p2][0])
       high = min(lista1[p1][1],lista2[p2][1])
       if low <= high:
           pila.append([low,high])
       if lista1[p1][1] < lista2[p2][1]:
           p1+=1
       else:
           p2+=1
   return pila
 */