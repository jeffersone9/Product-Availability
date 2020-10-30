export class Department{
    id: number;
    deptName: string;

    constructor(name: string){

    }

    public getId():number{
        return this.id
    }

    public setId(id:number){
        this.id = id;
    }

    public getName():string{
        return this.deptName;
    }

    public setName(name:string){
        this.deptName = name;
    }
}