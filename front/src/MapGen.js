import React, { Component } from 'react'
import L from 'leaflet';
import { GeoSearchControl, OpenStreetMapProvider } from 'leaflet-geosearch';


export default class MapGen extends Component {

    render() {
        const provider = new OpenStreetMapProvider();

        const map = new L.Map('mapGen').setView([51.505, -0.09], 13);
        L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
        }).addTo(map);


        new GeoSearchControl({
            provider: provider,                               // required
            autoComplete: true,             // optional: true|false  - default true
            autoCompleteDelay: 250,         // optional: number      - default 250
            showMarker: true,                                   // optional: true|false  - default true
            showPopup: true,                                   // optional: true|false  - default false
            marker: {                                           // optional: L.Marker    - default L.Icon.Default
                icon: new L.Icon.Default(),
                draggable: false,
            },
            popupFormat: ({ query, result }) => result.label,   // optional: function    - default returns result label
            maxMarkers: 1,                                      // optional: number      - default 1
            retainZoomLevel: false,                             // optional: true|false  - default false
            animateZoom: true,                                  // optional: true|false  - default true
            autoClose: false,                                   // optional: true|false  - default false
            searchLabel: 'Enter address',                       // optional: string      - default 'Enter address'
            keepResult: false                                   // optional: true|false  - default false
        }).addTo(map);



        return (
            <div className="maapamapma">
                <div id="map">

                </div>
            </div>

        )
    }
}