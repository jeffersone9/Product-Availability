import { Department } from './department.model';

export class Product{
    id: number;
    productName: string;
    department: Department;

    public getId():number{
        return this.id;
    }

    public setId(id:number){
        this.id = id;
    }

    public getName():string{
        return this.productName;
    }

    public setName(name:string){
        this.productName = name;
    }

    public getDepartment():Department{
        return this.department;
    }

    public setDepartment(department:Department){
        this.department = department;
    }
}