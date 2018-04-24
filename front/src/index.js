import React from 'react';
import ReactDOM from 'react-dom';
//import './index.css';


import 'leaflet/dist/leaflet.css';
import 'leaflet-geosearch/dist/style.css';
import 'leaflet/dist/leaflet.js';
import 'leaflet-geosearch/dist/bundle.js';
//import App from './App';
//import Map from './MapGen';
import Map from './MapGenReact';
import registerServiceWorker from './registerServiceWorker';

//ReactDOM.render(<App />, document.getElementById('root'));
ReactDOM.render(<Map />, document.getElementById('container'));
registerServiceWorker();
