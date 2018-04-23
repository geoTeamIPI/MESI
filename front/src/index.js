import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import 'leaflet-geosearch/dist/style.css';
import 'leaflet/dist/leaflet.css';
import App from './App';
import Map from './MapGen';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<App />, document.getElementById('root'));
ReactDOM.render(<Map />, document.getElementById('container'));
registerServiceWorker();
