package estructuras.AlgoritmosDeBusqueda.Subclasses;

import estructuras.NodoG;

import java.util.Hashtable;

public class MatrixElementV2 {

    public NodoG currentNode;
    public NodoG conexionNode;
    public NodoG originNode;

    public MatrixElementV2( NodoG originNode, NodoG conexionNode, NodoG currentNode) {
        this.currentNode = currentNode;
        this.conexionNode = conexionNode;
        this.originNode = originNode;
    }
}
