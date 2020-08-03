import { Injectable } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private upersons: User[] = [
    {
      empId: 1,
      firstName: 'Dehit',
      lastName: 'Garaga',
      age: 24,
      city: 'Hyderabad'

    },
    {
      empId: 2,
      firstName: 'Tejasvi',
      lastName: 'Surya',
      age: 31,
      city: 'Banglore'
    }
  ];

  constructor() { }

  getUsersFromData(): User[] {
    return this.upersons;
  }

  addUser(user: User) {
    user.empId = this.upersons.length + 1;
    this.upersons.push(user);

  }
  updateUser(user: User) {
    const index = this.upersons.findIndex(u => user.empId === u.empId);
    this.upersons[index] = user;
  }
  deleteUser(user: User) {
    this.upersons.splice(this.upersons.indexOf(user), 1);
  }

}
