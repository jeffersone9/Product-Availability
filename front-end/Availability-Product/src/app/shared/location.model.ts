export class Location{
    id: number;
    locationName: string;
    zipcode: string;

    constructor(name: string, zipcode: string){

    }

    public getId():number{
        return this.id;
    }

    public setId(id:number){
        this.id = id;
    }

    public getName():string{
        return this.locationName;
    }

    public setName(name:string){
        this.locationName = name;
    }

    public getZipcode():string{
        return this.zipcode;
    }

    public setZipcode(zipcode:string){
        this.zipcode = zipcode;
    }
}