#Universidad del Valle de Guatemala
#Daniela Batz 19214
#HDT10
import networkx as nx
from numpy import zeros, shape, inf
#Se debe abrir el archivo que se va a leer
infile = open('guategrafo.txt', 'r')
#Se muestra que se ha leido el archivo
print("Lectura del archivo exitosa")
ciudades=[]
for line in infile:
    divi=line.split()
    ciudades.append(divi)

#Econtrar la ruta mas corta
#Con algortimo FLoyd


def main():
    cont=0
    g=nx.DiGraph()
    while cont < len(ciudades):
        g.add_edge(ciudades[cont][0],ciudades[cont][1],weight=int(ciudades[cont][2]))
        cont=+1
    inicial=raw_input("Ingrese la ciudad de origen:")
    final=raw_input("Igrese la ciudad de llegada: ")
    Fin = final
    
    predecesor, distance = nx.floyd_warshall_predecessor_and_distance(g)
    distancia = predecesor[inicial].keys()
    
    n=0
    recorrido = []
    recorrido.append(final)
    
    while n < len(distancia):
        if distancia[n] == Fin:
            recorrido.append(predecesor[inicial][distancia[n]])
            if predecesor[inicial][distancia[n]] != inicial:
                Fin=predecesor[inicial][distancia[n]]
                n=-1
    print
    print ("Distancia: ")
    print (distance[inicial][final])
    print ("Camino más corto: ")
    n = len(recorrido) - 1
    while n>=0:
        print (recorrido[n])
        n=-1
    print ("Centro del grafo: ")
    print
    print (Fin)

main()

print ("Modificaciones: ")
while True:
    print ("a. Hay interrupciones de tráfico entre un par de ciudades \nO \nb. Se esteblece una conexión entre ciudad1 y ciudad2 con un valor de x KM de distancia")
    op=raw_input("Opcion: ")
    if op=="a":
        ciudad1=raw_input("Ingrese ciudad 1: ")
        ciudad2=raw_input("Ingrese ciudad 2: ")
        g.remove_edge(ciudad1,ciudad2)
        break
    if op=="b":
        ciudad1=raw_input("Ingrese ciudad 1: ")
        ciudad2=raw_input("Ingrese ciudad 2: ")
        dist=raw_input("Ingrese la distancia: ")
        g.add_edge(ciudad1,ciudad2,weight=int(dist))
        break
 
main()