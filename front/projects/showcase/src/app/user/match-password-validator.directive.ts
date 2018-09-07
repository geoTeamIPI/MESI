import { Directive, Input } from '@angular/core';
import { Validator, NG_VALIDATORS, AbstractControl } from '@angular/forms';

@Directive({
  selector: '[showcaseMatchPasswordValidator]',
  providers: [{
    provide: NG_VALIDATORS, 
    useExisting: MatchPasswordValidatorDirective, 
    multi: true
  }]
})
export class MatchPasswordValidatorDirective implements Validator{

  @Input() showcaseMatchPasswordValidator: string;
  validate(control: AbstractControl): {[key: string] : any} | null{
      const controlToCompare = control.parent.get(this.showcaseMatchPasswordValidator); 
      if (controlToCompare && controlToCompare.value !== control.value){
        return { 'notMatched': true }; 
      }
      return null; 
    }

}
