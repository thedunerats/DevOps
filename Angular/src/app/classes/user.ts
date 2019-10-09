export class User {
    private id:number;
    private username:string;
    private password:string;
    private userroleid:number;


    constructor() {}

    public getId(){return this.id;}
    public setId(id:number){this.id = id;}

    public getUsername(){return this.username;}
    public setUsername(username:string){this.username=username;}
    
    public getPassword(){return this.password;}
    public setPassword(password:string){this.password = password;}

    public getUserRoleId(){return this.userroleid}
    public setUserRoleId(userroleid:number){this.userroleid = userroleid;}
}