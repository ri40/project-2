import React from 'react';
import { ChakraProvider, theme } from '@chakra-ui/react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Card from './components/Card';
import Search from './components/Search';
import Footer from './components/Footer';
import Header from './components/Header';

function App() {
  return (
    <ChakraProvider theme={theme}>
      <BrowserRouter>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/card' element={<Card/>}/>
        <Route path='/search' element={<Search/>}/>
        <Route path='/footer' element={<Footer/>}/>
        <Route path='/header' element={<Header/>}/>



      </Routes>
      </BrowserRouter>
      
    </ChakraProvider>
  );
}

export default App;
