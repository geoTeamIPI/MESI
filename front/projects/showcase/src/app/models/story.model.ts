import { User } from "./user.model";

export class Story {
  id: number;
  title: string;
  description: string;
  content: string;
  creator: User;
  startingYear: number;
  startingMonth: number;
  startingDay: number;
  endingYear: number;
  endingMonth: number;
  endingDay: number;
  dateCreation : Date;
  dateUpdate : Date; 
}
