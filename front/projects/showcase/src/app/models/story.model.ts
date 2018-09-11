import { User } from "./user.model";
import { Timelapse } from "./timelapse.model";

export class Story {
  id: number;
  title: string;
  description: string;
  content: string;
  creator: User;
  //type: Type;
  timelapse: Timelapse;
  startingYear: number;
  startingMonth: number;
  startingDay: number;
  endingYear: number;
  endingMonth: number;
  endingDay: number;
  dateCreation : Date;
  dateUpdate : Date; 
}
