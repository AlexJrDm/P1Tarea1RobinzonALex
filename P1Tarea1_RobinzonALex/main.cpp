#include <iostream>
#include <fstream>

using namespace std;
float calf1, calf2, calf3, promedio;

void ingresarNotas();
float Promedio();

int main()
{
    int opc;
    ofstream archivo;
    string nombreArchivo;
    do{
        cout<<"MENU"<<endl;
        cout<<"1. Ingresar calificaciones"<<endl;
        cout<<"2. Generar Archivo"<<endl;
        cout<<"3. Salir"<<endl;
        cin>>opc;
        cin.ignore();
        switch(opc){
        case 1: {
        ingresarNotas();
        break;
        }
        case 2: {
            cout << "Digite el nombre del archivo: ";
            cin.ignore();
            getline(cin, nombreArchivo);
            archivo.open(nombreArchivo.c_str(), ios::out); // Crear el archivo

            if (archivo.fail()) { // Si ocurrió un error
                cout << "No se pudo abrir el archivo";
                exit(1);
            } else {
            cout<<"Archivo generado correctamente"<<endl;
            }
            archivo << "La calificación 1 es: " << calf1 << endl;
            archivo << "La calificación 2 es: " << calf2 << endl;
            archivo << "La calificación 3 es: " << calf3 << endl;
            archivo << "Su promedio es: " << Promedio() << endl;
            archivo.close();

        break;
        }
        case 3: {
            cout<<"SALIENDO..."<<endl;
        break;
        }
        }

    }while(opc != 3);
    return 0;
}

void ingresarNotas(){
    cout<<"Ingrese calificacion 1: ";
    cin>>calf1;
    while(calf1 < 0 || calf1>20){
        cout<<"Calificacion incorrecta, reingrese la calificacion nuevamente: ";
        cin>>calf1;
    }
    cout<<"Ingrese calificacion 2: ";
    cin>>calf2;
    while(calf2 < 0 || calf2>20){
        cout<<"Calificacion incorrecta, reingrese la calificacion nuevamente: ";
        cin>>calf2;
    }
    cout<<"Ingrese calificacion 3: ";
    cin>>calf3;
    while(calf3 < 0 || calf3>20){
        cout<<"Calificacion incorrecta, reingrese la calificacion nuevamente: ";
        cin>>calf3;
    }
    cout<<"Su promedio es: "<<Promedio()<<endl;
    if (Promedio() >= 14){
        cout<<"Usted esta aprobado. "<<endl;
    } else if(Promedio()<14){
        cout<<"Usted esta reprobado"<<endl;
    }
}

float Promedio(){
    promedio = (calf1+calf2+calf3)/3;
    return promedio;
}
