export class Zipcode{
    adminCode2: string;
    adminCode1: string;
    adminName2: string;
    lng: number;
    distance: string;
    countryCode: string;
    postalCode: string;
    placeName: string;
    adminName1: string
    lat: number;
    constructor(zipcode:string, city:string, state:string){
        this.postalCode = zipcode;
        this.placeName = city;
        this.adminName1 = state;
    }
}