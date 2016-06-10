package br.com.proj_int.model;

import java.util.Date;

public class Bem {

	private int id;
	private String nome;
	private int vd_util;
	private int turno;
	private int temp_uso;
	private Date dataAquisicao;
	private Date dataReferencia;

	private double cb;
	private double vr;
	private double i;
	private double n;
	private double da;
	private double vc;
	private double vv;
	private double g_p;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVd_util() {
		return vd_util;
	}

	public void setVd_util(int vd_util) {
		this.vd_util = vd_util;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public double getCb() {
		return cb;
	}

	public void setCb(double cb) {
		this.cb = cb;
	}

	public double getVr() {
		return vr;
	}

	public void setVr(double vr) {
		this.vr = vr;
	}

	public double getI() {
		return i;
	}

	public void setI(double i) {
		this.i = i;
	}

	public double getN() {
		return n;
	}

	public void setN(double n) {
		this.n = n;
	}

	public double getDa() {
		return da;
	}

	public void setDa(double da) {
		this.da = da;
	}

	public double getVc() {
		return vc;
	}

	public void setVc(double vc) {
		this.vc = vc;
	}

	public double getVv() {
		return vv;
	}

	public void setVv(double vv) {
		this.vv = vv;
	}

	public double getG_p() {
		return g_p;
	}

	public void setG_p(double g_p) {
		this.g_p = g_p;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public Date getDataReferencia() {
		return dataReferencia;
	}

	public void setDataReferencia(Date dataReferencia) {
		this.dataReferencia = dataReferencia;
	}

	@Override
	public String toString() {
		return "Bem [id=" + id + ", nome=" + nome + ", vd_util=" + vd_util
				+ ", turno=" + turno + ", dataAquisicao=" + dataAquisicao
				+ ", dataReferencia=" + dataReferencia + ", cb=" + cb + ", vr="
				+ vr + ", i=" + i + ", n=" + n + ", da=" + da + ", vc=" + vc
				+ ", vv=" + vv + ", g_p=" + g_p + "]";
	}
	
	public int getTemp_uso() {
		return temp_uso;
	}

	public void setTemp_uso(int temp_uso) {
		this.temp_uso = temp_uso;
	}

}
