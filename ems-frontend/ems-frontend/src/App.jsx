import './App.css'
import Employee from './Components/Employee/Employee'
import Footer from './Components/Footer/Footer'
import Header from './Components/Header/Header'
import ListEmployees from './Components/ListEmployees/ListEmployees'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

function App() {

  return (
    <>
    <BrowserRouter>
      <Header />
        <Routes>
          <Route path='/' element = { <ListEmployees/> }></Route>
          
          <Route path='/employees' element = { <ListEmployees/> }></Route>
        
          <Route path='/add-employee' element = { <Employee /> }></Route>
        
          <Route path='/edit-employee/:id' element = { <Employee /> }></Route>

        </Routes>
      <Footer />
    </BrowserRouter>
     
    </>
  )
}

export default App
