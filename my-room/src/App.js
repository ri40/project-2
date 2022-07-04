import React from 'react';
import { BrowserRouter, Routes, Route} from 'react-router-dom'
import Home from './room/Home';
import Hero from './compounent/Hero'
import Nav from './compounent/Nav'


function App() {
  return (
    <BrowserRouter>
    <Nav/>
      <Routes>
        <Route path="/" element={<Nav />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
