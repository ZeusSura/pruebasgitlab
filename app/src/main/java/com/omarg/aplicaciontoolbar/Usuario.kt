package com.omarg.aplicaciontoolbar

class Usuario {

    var id:Int=0
    var nombre:String =""
    var role:String = "USER_ROLE"

    constructor(id: Int, nombre: String, role: String) {
        this.id = id
        this.nombre = nombre
        this.role = role
    }
}