using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TAPAula
{
    internal class Mensalista : Empregado
    {
        public Double SalarioMensal { get; set; }

        public override double SalarioBruto()
        {
            return this.SalarioMensal;
        }
    }
}
