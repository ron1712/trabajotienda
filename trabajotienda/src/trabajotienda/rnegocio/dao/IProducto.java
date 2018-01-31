/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajotienda.rnegocio.dao;

import trabajotienda.rnegocio.dao.*;
import trabajotienda.rnegocio.entidades.*;
import  java.util.*;
public interface IProducto {
     public int insertar (Producto producto) throws Exception;
  public Producto obtener(String codigo) throws Exception;
    public ArrayList<Producto> obtener () throws Exception;

   
     
}
