import { DemoActions, DemoActionTypes } from './demo.actions';

export interface State {
  sidenavOpen: boolean;
}

export const initialState: State = {
  sidenavOpen: false
};

export function reducer(state = initialState, action: DemoActions): State {
  switch (action.type) {

    case DemoActionTypes.TOGGLE_SIDENAV:
      return { ...state, sidenavOpen: !state.sidenavOpen };
    default:
      return state;
  }
}
